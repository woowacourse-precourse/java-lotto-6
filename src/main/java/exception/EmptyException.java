package exception;

public class EmptyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 공백이 입력되어서는 안됩니다!";

    public EmptyException() {
        super(ERROR_MESSAGE);
    }
}
