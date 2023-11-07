package lotto.domain;

import lotto.constant.ErrorMessage;

public class Money {
    private final int money;
    public Money(int money) throws IllegalArgumentException{
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) throws IllegalArgumentException {
        if(money % ValidationConstants.STANDARD_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MOD_STANDARD_UNIT_NOT_ZERO.getMessage());
        }
    }
}
