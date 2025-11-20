package site.thedeny1106.projectPay.common;

public record ResponseEntity<T>(int status, T data, long count) {
}
