package site.thedeny1106.projectPay.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.thedeny1106.projectPay.product.domain.Product;

import java.util.UUID;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, UUID> {
}
