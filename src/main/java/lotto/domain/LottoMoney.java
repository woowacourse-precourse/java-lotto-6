package lotto.domain;

import lotto.exception.DivideMoneyException;
import lotto.exception.ZeroMoneyException;

public class LottoMoney {
    private static final int CANNOT_DIVIDE = 0;
    private static final int PURCHASE_MONEY = 1000;
    private static final int CAN_DIVIDE_MONEY = 0;

    public final int money;

    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateZero(money);
        validateDivide(money);
    }

    private void validateZero(int money) {
        if (money == CANNOT_DIVIDE) {
            throw new ZeroMoneyException();
        }
    }

    private void validateDivide(int money) {
        if (money % PURCHASE_MONEY == CAN_DIVIDE_MONEY) {
            return;
        }
        throw new DivideMoneyException();
    }
}
