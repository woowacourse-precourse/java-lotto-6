package lotto.domain;


import lotto.config.MoneyException;

public class Money {
    public static int MONEY_UNIT = 1000;
    public final int money;

    public Money(int money){
        validate(money);
        this.money = money;
    }

    private void validate(int money){
        if(money % MONEY_UNIT != 0){
            throw new MoneyException(money);
        }
    }
}
