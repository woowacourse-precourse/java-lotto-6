package lotto.model;

import lotto.utils.InputValidator;
import lotto.utils.StringConvertor;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final String money;

    public Money(String money) {
        validate(money);
        this.money = money;
    }

    private void validate(String money) {
        InputValidator.checkMoney(money);
    }

    public int calNumberOfLotto() {
        return StringConvertor.stringToInt(money) / LOTTO_PRICE;
    }

}
