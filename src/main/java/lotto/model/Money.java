package lotto.model;

import lotto.validator.MoneyValidator;

public class Money {
    private final int money;
    public Money(int money){
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money){
        MoneyValidator.validateMoneyRange(money);
    }
}
