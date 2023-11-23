package lotto.exception;

public class CustomNullPointAmountException extends NullPointerException {

    public CustomNullPointAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
