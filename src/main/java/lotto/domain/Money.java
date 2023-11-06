package lotto.domain;

import lotto.exception.DivideMoneyException;

public class Money {
    private static final int DIVIDE_STANDARD = 1000;
    private static final int CAN_DIVIDE_MONEY = 0;

    public final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateDivide(money);
    }

    private void validateDivide(int money) {
        if (money % DIVIDE_STANDARD == CAN_DIVIDE_MONEY) {
            return;
        }
        throw new DivideMoneyException();
    }
}
