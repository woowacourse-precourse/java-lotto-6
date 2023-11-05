package lotto.domain;

import lotto.exception.ZeroMoneyException;

public class LottoMoney {
    private static final int CANNOT_DIVIDE = 0;

    public final int money;

    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateZero(money);
    }

    private void validateZero(int money) {
        if (money == CANNOT_DIVIDE) {
            throw new ZeroMoneyException();
        }
    }
}
