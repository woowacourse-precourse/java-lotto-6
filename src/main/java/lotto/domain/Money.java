package lotto.domain;

import lotto.util.Validator;

public class Money {
    private String money = "";
    private Validator validator = new Validator();

    public Money(String inputMoney) {
        validator.money(inputMoney);
        this.money = inputMoney;
    }

    public int toLottoAmount() {
        return Integer.valueOf(money) / 1000;
    }

}
