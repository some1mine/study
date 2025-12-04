package site.thedeny1106.projectPay.kafka.dto;

public record AsyncOrderDispatchResult(
        String orderId,
        String topic,
        int partition,
        long offset
) {
}
