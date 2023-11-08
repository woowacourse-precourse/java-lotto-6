package lotto.exception;

public class InvalidRangeException extends IllegalArgumentException {
    public InvalidRangeException(String exceptionCode) {
        super(exceptionCode);
    }
}
