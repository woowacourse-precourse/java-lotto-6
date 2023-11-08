package lotto.model;

import lotto.message.ExceptionMessage;

public class Trial {
    private final int money;

    public Trial(int inputMoney) {
        this.money = inputMoney;
    }

    public int getTrial() {
        return money / 1000;
    }
}
