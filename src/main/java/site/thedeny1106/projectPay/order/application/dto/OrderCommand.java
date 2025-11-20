package site.thedeny1106.projectPay.order.application.dto;
import java.util.UUID;

public record OrderCommand(
        UUID productId,
        UUID memberId
) {
}
