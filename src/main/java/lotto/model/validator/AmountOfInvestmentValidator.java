package lotto.model.validator;

import static lotto.util.AmountOfLotto.LOTTO_PRICE;
import static lotto.util.AmountOfLotto.MAXIMUM_PRICE;
import static lotto.util.AmountOfLotto.MINIMUM_PRICE;
import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX;
import static lotto.util.ExceptionMessage.INVALID_INPUT_TYPE;
import static lotto.util.ExceptionMessage.NOT_DIVIDE_BY_LOTTO_PRICE;
import static lotto.util.ExceptionMessage.NOT_POSITIVE_INPUT;

public class AmountOfInvestmentValidator {

    public static void checkType(String amountOfLotto) {
        if (!amountOfLotto.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }

    public static void checkAmountWithinLottoPriceRange(long amountOfLotto) {
        checkMinimum(amountOfLotto);
        checkMaximum(amountOfLotto);
    }

    private static void checkMinimum(long amountOfLotto) {
        if (amountOfLotto < MINIMUM_PRICE.getPrice()) {
            throw new IllegalArgumentException(NOT_POSITIVE_INPUT.getMessage());
        }
    }

    private static void checkMaximum(long amountOfLotto) {
        if (amountOfLotto > MAXIMUM_PRICE.getPrice()) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX.getMessage());
        }
    }

    public static void checkDivideByLottoPrice(long amountOfLotto) {
        if (amountOfLotto % LOTTO_PRICE.getPrice() != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE_BY_LOTTO_PRICE.getMessage());
        }
    }
}
