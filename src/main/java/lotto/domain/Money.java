package lotto.domain;

import static lotto.constant.Number.*;
import static lotto.constant.message.ErrorMessage.*;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        overThousand(money);
        divideByThousand(money);
    }

    private void overThousand(int money) throws IllegalArgumentException{
        if(money<THOUSAND){
            throw new IllegalArgumentException(UNDER_THOUSAND);
        }
    }

    private void divideByThousand(int money) throws IllegalArgumentException{
        if(money%THOUSAND!=ZERO){
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_THOUSAND);
        }
    }
}
