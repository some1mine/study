package site.thedeny1106.study.infrastructure.common;

public record ResponseEntity<T>(int status, T data, long count) {
}
