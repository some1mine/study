package site.thedeny1106.projectPay.search;

public record ProductIndexRequest(
        String name, String brand, String category, int price
) {
}
