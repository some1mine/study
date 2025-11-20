package site.thedeny1106.projectPay.seller.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import site.thedeny1106.projectPay.seller.domain.Seller;

import java.util.UUID;

public interface SellerJpaRepository extends JpaRepository<Seller, UUID> {
}
