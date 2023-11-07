package lotto.domain;

import lotto.view.InputView;

public class Money {
    private final int amount;
    private static final int moneyCondition = 1000;

    public Money() {
        this.amount = InputView.inputMoney();
    }

    public int trial() {
        return amount / moneyCondition;
    }
}
