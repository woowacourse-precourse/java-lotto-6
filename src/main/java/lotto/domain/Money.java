package lotto.domain;

import lotto.util.Error;

public class Money {

    private final int money;

    public Money(int money){
        validateZero(money);
        validateIsDivision(money);
        this.money = money;
    }

    public int divideMoney1000(){
        return money / 1000;
    }

    private void validateZero(int money){
        if(money == 0){
            throw new IllegalArgumentException(Error.MONEY_ZERO_ERROR.message());
        }
    }

    private void validateIsDivision(int money){
        if(money % 1000 != 0 ){
            throw new IllegalArgumentException(Error.MONEY_DIVIDE_ERROR.message());
        }
    }
}
