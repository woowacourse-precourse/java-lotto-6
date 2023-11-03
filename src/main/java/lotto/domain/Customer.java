package lotto.domain;

import static lotto.exception.InputMoneyException.*;

public class Customer {
    private final Integer MONEY;

    public Customer(String money) {
        validate(money);
        this.MONEY = Integer.parseInt(money);
    }

    public Integer calculateLottoNum() {
        return MONEY / 1000;
    }
}
