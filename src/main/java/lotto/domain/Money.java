package lotto.domain;

import lotto.util.MoneyValidator;

public class Money {
    private String money = "";
    private MoneyValidator validator = new MoneyValidator();

    public Money(String inputMoney) {
        validator.money(inputMoney);
        this.money = inputMoney;
    }

    /**
     * 금액에 맞는 로또 갯수 계산
     *
     * @return 구매할 수 있는 로또 갯수
     */
    public int toLottoAmount() {
        return Integer.valueOf(money) / 1000;
    }

}
