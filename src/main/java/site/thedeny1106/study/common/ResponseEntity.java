package site.thedeny1106.study.common;

public record ResponseEntity<T>(int status, T data, long count) {
}
