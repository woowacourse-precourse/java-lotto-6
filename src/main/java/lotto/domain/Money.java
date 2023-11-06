package lotto.domain;

import static lotto.constant.LottoConstant.MONEY_UNIT;
import static lotto.exception.ErrorMessage.INVALID_UNIT;
import static lotto.exception.ErrorMessage.NOT_ENOUGH_MONEY;

import lotto.exception.LottoException;

public class Money {

    private static final int ZERO = 0;

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(final int money) {
        validateMoney(money);
        return new Money(money);
    }

    private static void validateMoney(final int money) {
        if (isNotPositive(money)) {
            throw LottoException.of(NOT_ENOUGH_MONEY);
        }

        if (isNotCorrectUnit(money)) {
            throw LottoException.of(INVALID_UNIT);
        }
    }

    private static boolean isNotPositive(int money) {
        return money <= ZERO;
    }

    private static boolean isNotCorrectUnit(final int money) {
        return money % MONEY_UNIT.getValue() != 0;
    }

    public int calculateLottoCount() {
        return money / MONEY_UNIT.getValue();
    }
}
