package lotto.domain;

import lotto.validator.Validator;

public class Money {

    private final Long lottoPrice = 1000L;

    private final Long money;

    public Money(Long money) {
        validate(money);
        this.money = money;
    }

    private void validate(Long money) {
        Validator.validateMoneyLimit(money);
        Validator.validateMoneyModNoneZero(money);
    }

    public Long getMoney() {
        return money;
    }

    public Long getNumberOfLotto() {
        return money / lottoPrice;
    }
}
