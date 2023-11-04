package lotto.validator.input.exception;

public class InputIllegalArgumentException extends IllegalArgumentException {

    public InputIllegalArgumentException(final InputExceptionMessage message) {
        super(message.value());
    }
}
