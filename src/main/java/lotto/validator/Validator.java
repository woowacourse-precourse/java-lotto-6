package lotto.validator;

import lotto.domain.enums.LottoConstraint;
import lotto.domain.enums.Message;

public class Validator {
    public static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw Message.INVALID_NUMBER_FORMAT.createException();
        }
    }

    public static void validateRange(final int number) {
        if (number < LottoConstraint.START_RANGE_NUMBER.getValue() || number > LottoConstraint.END_RANGE_NUMBER.getValue()) {
            throw Message.ERROR_INVALID_RANGE_MESSAGE.createException();
        }
    }

    public static void validatePrice(String price){
        validateNumber(price);
        validatePriceRange(Integer.parseInt(price));
    }

    private static void validatePriceRange(int price) {
        if (price % LottoConstraint.LOTTO_UNIT_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Message.ERROR_INVALID_PRICE_NOT_DIVISIBLE_BY_1000_MESSAGE.getValue());
        }
    }
}
