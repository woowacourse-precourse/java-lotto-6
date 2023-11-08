package lotto.domain;

import lotto.common.ErrorMessage;

public class Money {

    private final int money;

    public Money(int money){
        validate(money);
        this.money = money;
    }

    private void validate(int money){
        validateZero(money);
        validateMoney(money);
    }

    private void validateZero(int money){
        if(money == 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_ZERO.getMessage());
        }
    }

    private void validateMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_MONEY.getMessage());
        }
    }
}
