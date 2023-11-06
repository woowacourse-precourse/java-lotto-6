package lotto.domain;

import lotto.util.MoneyValidator;

public class Money {
    private String money = "";
    private MoneyValidator validator = new MoneyValidator();

    public Money(String inputMoney) {
        validator.money(inputMoney);
        this.money = inputMoney;
    }

    public int toLottoAmount() {
        return Integer.valueOf(money) / 1000;
    }

}
