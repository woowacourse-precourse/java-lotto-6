package lotto.domain;

import java.util.List;

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
            throw new IllegalArgumentException();
        }
    }
}
