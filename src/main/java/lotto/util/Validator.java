package lotto.util;

import static lotto.domain.LottoRule.PRICE;
import static lotto.util.ErrorMessage.INPUT_NOT_NUMBER;
import static lotto.util.ErrorMessage.INPUT_NOT_THOUSAND_UNIT;
import static lotto.util.ErrorMessage.INPUT_TOO_MUCH_MONEY;

public class Validator {

    public void validateMoney(final String money) {
        validateNumber(money);
        validateThousandUnit(Integer.parseInt(money));
        validateAmount(Long.parseLong(money));
    }

    public void validateNumber(final String number) {
        final String REGEX = "[0-9]+";
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER.getMessage());
        }
    }

    public void validateThousandUnit(final int money) {
        if (money <= 0 || money % PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    public void validateAmount(final Long money) {
        if (money > 2000000000) {
            throw new IllegalArgumentException(INPUT_TOO_MUCH_MONEY.getMessage());
        }
    }
}
