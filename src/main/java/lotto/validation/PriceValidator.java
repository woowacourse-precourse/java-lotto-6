package lotto.validation;

import static lotto.constant.ValidateMessage.PRICE_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.constant.ValidateMessage.PRICE_IS_NOT_INTEGER;

public class PriceValidator {

    public void isNullOrEmpty(String price) {
        if (price == null || price.length() == 0) {
            PRICE_CANNOT_BE_NULL_OR_EMPTY.throwException();
        }
    }

    public int isInteger(String price) {
        if (!isNumeric(price)) {
            PRICE_IS_NOT_INTEGER.throwException();
        }
        return Integer.parseInt(price);
    }

    private boolean isNumeric(String price) {
        try {
            Integer.parseInt(price);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
