package lotto.domain;

import lotto.Validate;

public class Money {
    private int money;
    private final Validate validate = new Validate();
    public Money(String inputMoney) {
        validate.IsInteger(inputMoney);
        money = Integer.parseInt(inputMoney);
        checkMoney(money);
    }

    public void checkMoney(int money) {
        validate.IsThousands(money);
    }

    public int getMoney() {
        return money;
    }
}
