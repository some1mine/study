package site.thedeny1106.projectPay.search;

import java.util.List;

public record ProductSearchResponse(long total, List<ProductDocument> items) {
}