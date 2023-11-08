package lotto.common.exception;

public class InputException extends IllegalArgumentException {
    public InputException(InputErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }
}
