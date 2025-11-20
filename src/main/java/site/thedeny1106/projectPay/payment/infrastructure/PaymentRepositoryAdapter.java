package site.thedeny1106.projectPay.payment.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import site.thedeny1106.projectPay.payment.domain.Payment;
import site.thedeny1106.projectPay.payment.domain.PaymentRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {

    private final PaymentJpaRepository repository;

    @Override
    public Page<Payment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
    }
}
