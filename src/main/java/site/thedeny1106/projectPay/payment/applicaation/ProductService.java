package site.thedeny1106.projectPay.payment.applicaation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.thedeny1106.projectPay.common.ResponseEntity;
import site.thedeny1106.projectPay.payment.applicaation.dto.ProductCommand;
import site.thedeny1106.projectPay.payment.applicaation.dto.ProductInfo;
import site.thedeny1106.projectPay.payment.domain.Product;
import site.thedeny1106.projectPay.payment.domain.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ResponseEntity<List<ProductInfo>> findAll(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        List<ProductInfo> products = page.stream()
                .map(ProductInfo::from)
                .toList();
        return new ResponseEntity<>(HttpStatus.OK.value(), products, page.getTotalElements());
    }

    public ResponseEntity<ProductInfo> create(ProductCommand command) {
        Product product = Product.create(
                command.name(),
                command.description(),
                command.price(),
                command.stock(),
                command.status(),
                command.operatorId()
        );
        ProductInfo response = ProductInfo.from(productRepository.save(product));

        return new ResponseEntity<>(HttpStatus.OK.value(), response, 1);
    }

    public ResponseEntity<ProductInfo> update(String id, ProductCommand command) {
        Product found = productRepository.findById(UUID.fromString(id)).orElse(null);
        if (found == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND.value(),  null, 0);

        Product product = Product.create(
                command.name(),
                command.description(),
                command.price(),
                command.stock(),
                command.status(),
                command.operatorId()
        );

        ProductInfo response = ProductInfo.from(productRepository.save(product));

        return new ResponseEntity<>(HttpStatus.OK.value(), response, 1);
    }

    public ResponseEntity<?> delete(String id) {
        productRepository.deleteById(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.OK.value(), 1, 1);
    }
}
