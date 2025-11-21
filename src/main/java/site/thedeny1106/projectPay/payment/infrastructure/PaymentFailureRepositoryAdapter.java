package site.thedeny1106.projectPay.payment.infrastructure;

import org.springframework.stereotype.Repository;
import site.thedeny1106.projectPay.payment.domain.PaymentFailure;
import site.thedeny1106.projectPay.payment.domain.PaymentFailureRepository;

@Repository
public class PaymentFailureRepositoryAdapter implements PaymentFailureRepository {

    private final PaymentFailureJpaRepository repository;

    public PaymentFailureRepositoryAdapter(PaymentFailureJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentFailure save(PaymentFailure failure) {
        return repository.save(failure);
    }
}
