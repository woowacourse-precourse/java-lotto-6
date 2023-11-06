package lotto.model.validator;

import static lotto.model.util.AmountOfLotto.LOTTO_PRICE;
import static lotto.model.util.AmountOfLotto.MAXIMUM_PRICE;
import static lotto.model.util.AmountOfLotto.MINIMUM_PRICE;
import static lotto.model.util.ExceptionMessage.BIGGER_THAN_MAX;
import static lotto.model.util.ExceptionMessage.INVALID_INPUT_TYPE;
import static lotto.model.util.ExceptionMessage.NOT_DIVIDE_BY_LOTTO_PRICE;
import static lotto.model.util.ExceptionMessage.NOT_POSITIVE_INPUT;

public class AmountOfLottoValidatorImpl implements AmountOfLottoValidator {

    @Override
    public void checkType(String amountOfLotto) {
        if (!amountOfLotto.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }

    @Override
    public void checkAmountWithinLottoPriceRange(long amountOfLotto) {
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

    @Override
    public void checkDivideByLottoPrice(long amountOfLotto) {
        if (amountOfLotto % LOTTO_PRICE.getPrice() != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE_BY_LOTTO_PRICE.getMessage());
        }
    }
}
