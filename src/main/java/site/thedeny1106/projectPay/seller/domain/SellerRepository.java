package site.thedeny1106.projectPay.seller.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SellerRepository {
    Page<Seller> findAll(Pageable pageable);

    Optional<Seller> findById(UUID id);

    Seller save(Seller seller);

    void deleteById(UUID id);
}
