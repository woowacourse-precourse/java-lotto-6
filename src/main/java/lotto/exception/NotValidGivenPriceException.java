package lotto.exception;

public class NotValidGivenPriceException extends IllegalArgumentException {

    public NotValidGivenPriceException() {
        super(ExceptionMessage.NOT_VALID_GIVEN_PRICE_ERROR.getMessage());
    }
}
