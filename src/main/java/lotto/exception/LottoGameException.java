package lotto.exception;

public class LottoGameException extends IllegalArgumentException {
    private final ErrorMessage errorMessage;

    public LottoGameException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
