package lotto.validation;

import static lotto.constant.Constant.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorInputException.ErrorMessage.PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.exception.ErrorInputException.ErrorMessage.PURCHASE_PRICE_IS_MORE_THAN_ONE;
import static lotto.exception.ErrorInputException.ErrorMessage.PURCHASE_PRICE_IS_NOT_INTEGER;

import lotto.exception.ErrorInputException;

public class PurchasePriceValidator {
    public static void isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new ErrorInputException(PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public int isInteger(String input) {
        if (!isNumeric(input)) {
            throw new ErrorInputException(PURCHASE_PRICE_IS_NOT_INTEGER);
        }
        return Integer.parseInt(input);
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int moreThanOne(int input) {
        if (input < MIN_LOTTO_NUMBER) {
            throw new ErrorInputException(PURCHASE_PRICE_IS_MORE_THAN_ONE);
        }
        return input;
    }
}
