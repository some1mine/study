package site.thedeny1106.projectPay.settelment.infrastrcture;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.thedeny1106.projectPay.settelment.domain.SellerSettlement;
import site.thedeny1106.projectPay.settelment.domain.SellerSettlementRepository;
import site.thedeny1106.projectPay.settelment.domain.SettlementStatus;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SellerSettlementRepositoryAdapter implements SellerSettlementRepository {

    private final SellerSettlementJpaRepository sellerSettlementJpaRepository;

    @Override
    public SellerSettlement save(SellerSettlement settlement) {
        return sellerSettlementJpaRepository.save(settlement);
    }

    @Override
    public List<SellerSettlement> findByStatus(SettlementStatus status) {
        return sellerSettlementJpaRepository.findByStatus(status);
    }

    @Override
    public List<SellerSettlement> findByStatusAndSeller(SettlementStatus status, UUID sellerId) {
        return sellerSettlementJpaRepository.findByStatusAndSellerId(status, sellerId);
    }

    @Override
    public void saveAll(List<SellerSettlement> settlements) {
        sellerSettlementJpaRepository.saveAll(settlements);
    }
}
