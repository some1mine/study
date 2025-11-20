package site.thedeny1106.projectPay.order.infrastrcture;
import org.springframework.data.jpa.repository.JpaRepository;
import site.thedeny1106.projectPay.order.domain.PurchaseOrder;

import java.util.UUID;

public interface PurchaseOrderJpaRepository extends JpaRepository<PurchaseOrder, UUID> {
}

