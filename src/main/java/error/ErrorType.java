package error;


public enum ErrorType {
    USER_INPUT(new IllegalArgumentException()),
    METHOD_INVOKED_INAPPROPRIATE(new IllegalStateException());
    private final RuntimeException exception;


    ErrorType(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException getException() {
        return exception;
    }
}
