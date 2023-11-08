package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.ValidationConstant;

public class Money {
    private final int money;
    public Money(int money) throws IllegalArgumentException{
        validate(money);
        this.money = money;
    }

    private void validate(int money) throws IllegalArgumentException {
        if(money % ValidationConstant.STANDARD_MONEY_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MOD_STANDARD_UNIT_NOT_ZERO.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
