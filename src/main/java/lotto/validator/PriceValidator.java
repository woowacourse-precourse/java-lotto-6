package lotto.validator;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class PriceValidator {
    private static final int PRICE_UNIT = 1000;
    private static final int PRICE_LIMIT = 1000;
    private static final int REMAIN_ZERO = 0;

    public static Integer validatePrice(int userInput) {
        validateAmount(userInput);
        validateUnit(userInput);

        return userInput;
    }

    private static void validateUnit(int userInput) {
        if (isNotRequiredUnit(userInput)) {
            throw new LottoException(ErrorMessage.NON_REQUIRED_UNIT);
        }
    }

    private static boolean isNotRequiredUnit(int userInput) {
        return userInput % PRICE_UNIT != REMAIN_ZERO;
    }

    private static void validateAmount(int userInput) {
        if (isLowerThanLimit(userInput)) {
            throw new LottoException(ErrorMessage.UNDER_LIMIT);
        }
    }

    private static boolean isLowerThanLimit(int userInput) {
        return userInput < PRICE_LIMIT;
    }
}
