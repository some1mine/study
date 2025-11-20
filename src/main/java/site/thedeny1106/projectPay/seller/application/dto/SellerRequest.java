package site.thedeny1106.projectPay.seller.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record SellerRequest (
        UUID id,
        String companyName,
        String representativeName,
        String email,
        String phone,
        String businessNumber,
        String address,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){
    public SellerCommand toCommand() {
        return new SellerCommand(
                companyName,
                representativeName,
                email,
                phone,
                businessNumber,
                address,
                status,
                createdAt,
                updatedAt
        );
    }
}
