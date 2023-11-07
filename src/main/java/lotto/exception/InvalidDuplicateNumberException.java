package lotto.exception;

public class InvalidDuplicateNumberException extends IllegalArgumentException {
    public InvalidDuplicateNumberException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
