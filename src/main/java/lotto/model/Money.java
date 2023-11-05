package lotto.model;

import lotto.utils.InputValidator;

public class Money {
    private String money;

    public Money(String money) {
        validate(money);
        this.money = money;
    }

    private void validate(String money) {
        InputValidator.checkMoney(money);
    }

}
