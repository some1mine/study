package site.thedeny1106.projectPay.infrastructure.common;

public record ResponseEntity<T>(int status, T data, long count) {
}
