package lotto.model;

import static lotto.util.GameConstant.*;

public class Prize {
    private long money;

    protected Prize() {
        this.money = CONSTANT_INITIAL_VALUE.getConstant();
    }

    protected void addPrize(long money) {
        this.money += money;
    }

    protected double getMoney() {
        return this.money;
    }
}
