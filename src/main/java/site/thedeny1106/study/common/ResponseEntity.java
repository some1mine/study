package site.thedeny1106.study.common;

public class ResponseEntity<T>{
    private int status;
    private T data;
    private int count;

    public ResponseEntity(int status, T data, int count) {
        this.status = status;
        this.data = data;
        this.count = count;
    }
}
