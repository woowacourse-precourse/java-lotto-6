package lotto.exception;

public class NotValidGivenPriceError extends IllegalArgumentException {

    public NotValidGivenPriceError() {
        super(ExceptionMessage.NOT_VALID_GIVEN_PRICE_ERROR.getMessage());
    }
}
