package lotto.domain;

import lotto.service.Validate;

public class Money {

    private int money;
    private final Validate validate = new Validate();

    public Money(int money) {
        validate.IsThousandFormat(money);
        this.money = money;
    }


    public int getMoney() {
        return this.money;
    }

}