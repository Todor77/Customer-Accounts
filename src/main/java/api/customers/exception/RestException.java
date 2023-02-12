package api.customers.exception;


public class RestException extends RuntimeException{

    private int code;

    public RestException() {
    }

    public RestException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
