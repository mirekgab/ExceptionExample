package pl.mirekgab.exceptionexample.exception;

/**
 * Exception message send to api client
 */
public class ExceptionMessage {
    public static final String STATUS_INCOME_NOT_FOUND = "INCOME_NOT_FOUND";
    public static final String STATUS_WALLET_NOT_FOUND ="WALLET_NOT_FOUND";
    public static final String STATUS_SERVER_ERROR = "SERVER_ERROR";

    public static final int CODE_NOT_FOUND =404;
    public static final int CODE_SERVER_ERROR = 500;
    public static final int CODE_BAD_REQUEST = 400;

    private Integer code;
    private String status;

    public ExceptionMessage(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
