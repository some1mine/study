package site.thedeny1106.projectPay.payment.infrastructure;


import org.springframework.data.jpa.repository.JpaRepository;
import site.thedeny1106.projectPay.payment.domain.PaymentFailure;

import java.util.UUID;

public interface PaymentFailureJpaRepository extends JpaRepository<PaymentFailure, UUID> {
}
