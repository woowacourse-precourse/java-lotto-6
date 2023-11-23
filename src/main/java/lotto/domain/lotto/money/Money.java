package lotto.domain.lotto.money;

import java.math.BigDecimal;
import lotto.exception.LottoException;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public static Money nonZeroMoney(int money) {
        validateNonzero(money);
        return new Money(money);
    }

    private static void validateNonzero(int money) {
        if (money == 0) {
            throw LottoException.MONEY_INVALID_VALUE.makeException();
        }
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw LottoException.MONEY_INVALID_VALUE.makeException();
        }
        if (money % 1_000 != 0) {
            throw LottoException.MONEY_INVALID_VALUE.makeException();
        }
    }

    public Cash toCash() {
        return new Cash(this.money);
    }

    public BigDecimal toBigDecimal() {
        return new BigDecimal(this.money);
    }
}
