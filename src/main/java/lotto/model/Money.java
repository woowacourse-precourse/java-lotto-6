package lotto.model;

import lotto.utils.InputValidator;
import lotto.utils.StringConvertor;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(String money) {
        validate(money);
        this.money = StringConvertor.stringToInt(money);
    }

    private void validate(String money) {
        InputValidator.checkMoney(money);
    }

    public int calNumberOfLotto() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

}
