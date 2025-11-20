package site.thedeny1106.projectPay.payment.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.thedeny1106.projectPay.common.ResponseEntity;
import site.thedeny1106.projectPay.order.application.OrderService;
import site.thedeny1106.projectPay.order.domain.PurchaseOrder;
import site.thedeny1106.projectPay.payment.application.dto.PaymentCommand;
//import site.thedeny1106.projectPay.payment.application.dto.PaymentFailCommand;
//import site.thedeny1106.projectPay.payment.application.dto.PaymentFailureInfo;
import site.thedeny1106.projectPay.payment.application.dto.PaymentInfo;
import site.thedeny1106.projectPay.payment.client.TossPaymentClient;
//import site.thedeny1106.projectPay.payment.client.TossPaymentResponse;
import site.thedeny1106.projectPay.payment.domain.Payment;
//import site.thedeny1106.projectPay.payment.domain.PaymentFailure;
//import site.thedeny1106.projectPay.payment.domain.PaymentFailureRepository;
import site.thedeny1106.projectPay.payment.domain.PaymentRepository;
import site.thedeny1106.projectPay.settelment.domain.SellerSettlement;
import site.thedeny1106.projectPay.settelment.domain.SellerSettlementRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
//    private final PaymentFailureRepository paymentFailureRepository;
    private final SellerSettlementRepository sellerSettlementRepository;
    private final TossPaymentClient tossPaymentClient;
    private final OrderService orderService;

    public PaymentService(PaymentRepository paymentRepository,
//                          PaymentFailureRepository paymentFailureRepository,
                          SellerSettlementRepository sellerSettlementRepository,
                          TossPaymentClient tossPaymentClient,
                          OrderService orderService) {
        this.paymentRepository = paymentRepository;
//        this.paymentFailureRepository = paymentFailureRepository;
        this.sellerSettlementRepository = sellerSettlementRepository;
        this.tossPaymentClient = tossPaymentClient;
        this.orderService = orderService;
    }

    public ResponseEntity<List<PaymentInfo>> findAll(Pageable pageable) {
        Page<Payment> page = paymentRepository.findAll(pageable);
        List<PaymentInfo> payments = page.stream()
                .map(PaymentInfo::from)
                .toList();
        return new ResponseEntity<>(HttpStatus.OK.value(), payments, page.getTotalElements());
    }

//    public ResponseEntity<PaymentInfo> confirm(PaymentCommand command) {
//        TossPaymentResponse tossPayment = tossPaymentClient.confirm(command);
//        UUID orderId = UUID.fromString(tossPayment.orderId());
//        PurchaseOrder order = orderService.findEntity(orderId);
//        Payment payment = Payment.create(
//                tossPayment.paymentKey(),
//                tossPayment.orderId(),
//                tossPayment.totalAmount()
//        );
//        LocalDateTime approvedAt = tossPayment.approvedAt() != null ? tossPayment.approvedAt().toLocalDateTime() : null;
//        LocalDateTime requestedAt = tossPayment.requestedAt() != null ? tossPayment.requestedAt().toLocalDateTime() : null;
//        payment.markConfirmed(tossPayment.method(), approvedAt, requestedAt);
//
//        Payment saved = paymentRepository.save(payment);
//        orderService.markPaid(order);
//        SellerSettlement settlement = SellerSettlement.create(
//                order.getSellerId(),
//                order.getId(),
//                order.getAmount()
//        );
//        sellerSettlementRepository.save(settlement);
//        return new ResponseEntity<>(HttpStatus.CREATED.value(), PaymentInfo.from(saved), 1);
//    }
//
//    public ResponseEntity<PaymentFailureInfo> recordFailure(PaymentFailCommand command) {
//        PaymentFailure failure = PaymentFailure.from(
//                command.orderId(),
//                command.paymentKey(),
//                command.errorCode(),
//                command.errorMessage(),
//                command.amount(),
//                command.rawPayload()
//        );
//        PaymentFailure saved = paymentFailureRepository.save(failure);
//        return new ResponseEntity<>(HttpStatus.OK.value(), PaymentFailureInfo.from(saved), 1);
//    }
}

