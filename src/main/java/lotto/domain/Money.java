package lotto.domain;

import lotto.exception.DivideMoneyException;
import lotto.exception.NegativeMoneyException;

public class Money {
    private static final int DIVIDE_STANDARD = 1000;
    private static final int CAN_DIVIDE_MONEY = 0;
    private static final int MIN_MONEY = 0;

    public final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateNegative(money);
        validateDivide(money);
    }

    private void validateNegative(int money) {
        if (money < MIN_MONEY) {
            throw new NegativeMoneyException();
        }
    }

    private void validateDivide(int money) {
        if (money % DIVIDE_STANDARD == CAN_DIVIDE_MONEY) {
            return;
        }
        throw new DivideMoneyException();
    }

    public int getMoney() {
        return money;
    }
}
