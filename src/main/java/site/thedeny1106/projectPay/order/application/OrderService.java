package site.thedeny1106.projectPay.order.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.thedeny1106.projectPay.common.ResponseEntity;
import site.thedeny1106.projectPay.order.application.dto.OrderCommand;
import site.thedeny1106.projectPay.order.application.dto.OrderInfo;
import site.thedeny1106.projectPay.order.domain.PurchaseOrder;
import site.thedeny1106.projectPay.order.domain.PurchaseOrderRepository;
import site.thedeny1106.projectPay.product.domain.Product;
import site.thedeny1106.projectPay.product.domain.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final PurchaseOrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(PurchaseOrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public ResponseEntity<OrderInfo> create(OrderCommand command) {
        if (command.productId() == null || command.memberId() == null) {
            throw new IllegalArgumentException("productId and memberId are required");
        }
        Product product = productRepository.findById(command.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + command.productId()));

        PurchaseOrder order = PurchaseOrder.create(
                product.getId(),
                product.getSellerId(),
                command.memberId(),
                product.getPrice()
        );
        PurchaseOrder saved = orderRepository.save(order);
        return new ResponseEntity<>(HttpStatus.CREATED.value(), OrderInfo.from(saved), 1);
    }

    public ResponseEntity<List<OrderInfo>> findAll(Pageable pageable) {
        Page<PurchaseOrder> page = orderRepository.findAll(pageable);
        List<OrderInfo> infos = page.stream().map(OrderInfo::from).toList();
        return new ResponseEntity<>(HttpStatus.OK.value(), infos, page.getTotalElements());
    }

    public PurchaseOrder findEntity(UUID orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
    }

    public void markPaid(PurchaseOrder order) {
        order.markPaid();
        orderRepository.save(order);
    }
}

