package lotto.model;

import static lotto.util.message.Digit.MONEY_UNIT;
import static lotto.util.message.Error.MUST_MONEY_UNIT;

public class Purchase {

    private final static int MONEY_CONDITION = 0;

    private final int money;
    private final int count;

    public Purchase(int money) {
        validate(money);
        this.money = money;
        this.count = money / MONEY_UNIT.getNumber();
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    private void validate(int money) {
        if (money % MONEY_UNIT.getNumber() != MONEY_CONDITION || money <= MONEY_CONDITION) {
            throw new IllegalArgumentException(MUST_MONEY_UNIT.getError(MONEY_UNIT.getNumber()));
        }
    }
}
