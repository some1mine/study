package site.thedeny1106.projectPay.settelment.infrastrcture;

import org.springframework.data.jpa.repository.JpaRepository;
import site.thedeny1106.projectPay.settelment.domain.SellerSettlement;
import site.thedeny1106.projectPay.settelment.domain.SettlementStatus;

import java.util.List;
import java.util.UUID;

public interface SellerSettlementJpaRepository extends JpaRepository<SellerSettlement, UUID> {

    List<SellerSettlement> findByStatus(SettlementStatus status);

    List<SellerSettlement> findByStatusAndSellerId(SettlementStatus status, UUID sellerId);
}