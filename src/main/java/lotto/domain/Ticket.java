package lotto.domain;

import lotto.type.ErrorCode;

public class Ticket {

    private static final int PRICE = 1000;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int moneyInput) {
        validate(moneyInput);
        this.count = moneyInput / PRICE;
    }

    private void validate(int moneyInput) {
        if (moneyInput % PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MONEY_TO_BUY.getDescription());
        }
    }
}
