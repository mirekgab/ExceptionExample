package pl.mirekgab.exceptionexample.exception;

public class AppRuntimeException extends RuntimeException {
    private final int code;
    public AppRuntimeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
