package lotto.domain;

import lotto.validator.MoneyValidator;

public class Money {

    private String money;

    public Money(String money) {
        validate(money);
        this.money = money;
    }

    private void validate(String input) {
        MoneyValidator validator = new MoneyValidator(input);
    }

    public int getMoney() {
        return Integer.parseInt(money);
    }

}
