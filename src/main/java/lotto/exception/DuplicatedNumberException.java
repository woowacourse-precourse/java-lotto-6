package lotto.exception;

public class DuplicatedNumberException extends IllegalArgumentException {
    public DuplicatedNumberException() {

    }
    public DuplicatedNumberException(String message) {
        super(message);
    }
}
