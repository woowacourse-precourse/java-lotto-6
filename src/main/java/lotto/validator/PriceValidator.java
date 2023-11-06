package lotto.validator;

import lotto.exception.NotValidGivenPriceException;

public class PriceValidator {
    private PriceValidator() {
    }

    public static void validatePrice(int price) throws IllegalArgumentException {
        if (price == 0 || price % ValidNumber.LOTTO_PRICE_UNIT.getNumber() != 0) {
            throw new NotValidGivenPriceException();
        }
    }

}
