package lotto.model;

import lotto.utils.InputValidator;

public class Price {
    private String money;

    public Price(String money) {
        validate(money);
        this.money = money;
    }

    private void validate(String money) {
        InputValidator.checkPrice(money);
    }

}
