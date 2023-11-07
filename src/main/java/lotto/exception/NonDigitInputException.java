package lotto.exception;

public class NonDigitInputException extends IllegalArgumentException {
    public NonDigitInputException(String message) {
        super(message);
    }
}