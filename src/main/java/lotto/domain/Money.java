package lotto.domain;

import lotto.exception.NotNaturalMoneyException;
import lotto.exception.WrongMoneyUnitException;

public class Money {
    private static final long CURRENCY = 1000;

    private final long money;

    private Money(Long money) {
        checkDividedByCurrency(money);
        checkNaturalWith(money);
        this.money = money;
    }

    public static Money valueOf(String money) {

        return new Money(Long.parseLong(money));
    }

    public long showCountConvertTo(long currency) {
        return money / currency;
    }

    public long showMoney() {
        return money;
    }

    private static void checkDividedByCurrency(long money) {
        if (money % CURRENCY != 0) {
            throw new WrongMoneyUnitException();
        }
    }

    private static void checkNaturalWith(long money) {
        if (money <= 0) {
            throw new NotNaturalMoneyException();
        }
    }


}
