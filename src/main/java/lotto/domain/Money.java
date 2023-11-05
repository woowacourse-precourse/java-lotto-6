package lotto.domain;

import static lotto.common.ErrorMessages.NOT_A_NUMBER;
import static lotto.common.ErrorMessages.NOT_IN_1000_UNIT;
import static lotto.common.ErrorMessages.NULL_OR_EMPTY;
import static lotto.utils.StringUtils.isDigit;
import static org.junit.platform.commons.util.StringUtils.isBlank;

import lotto.exception.InputValidationException;

public class Money {
    public static final int COST_PER_LOTTO = 1000;
    private int money;

    public Money(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        if (isBlank(money)) {
            throw new InputValidationException(NULL_OR_EMPTY);
        }

        if (!isDigit(money)) {
            throw new InputValidationException(NOT_A_NUMBER, money);
        }

        if (Integer.parseInt(money) % COST_PER_LOTTO != 0) {
            throw new InputValidationException(NOT_IN_1000_UNIT, money);
        }
    }

    public int getDividedThousandWonCount() {
        return money / COST_PER_LOTTO;
    }

    public int getMoney() {
        return money;
    }
}
