package util.exception;

public class DuplicateException extends IllegalArgumentException {
    public DuplicateException(final String message) {
        super(message);
    }
}
