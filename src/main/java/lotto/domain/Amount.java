package lotto.domain;

import lotto.Message;

import static lotto.Message.NOT_VALID_MONEY;

public class Amount {
    protected final int unitOfMoney = 1000;
    protected final int amount;

    public Amount(int amount){
        validateNotHasRemainder(amount);
        this.amount = amount;
    }

    private void validateNotHasRemainder(int amount){
        if(amount % unitOfMoney != 0) throw new IllegalArgumentException(NOT_VALID_MONEY);
    }


}
