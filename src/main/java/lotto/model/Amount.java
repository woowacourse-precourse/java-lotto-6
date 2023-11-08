package lotto.model;

import lotto.common.Constant;
import lotto.common.ErrorMessage;

public class Amount {

    private final int amount;

    public Amount(int amount){
        validateIsThousand(amount);
        validateIsPositive(amount);
        this.amount = amount;
    }

    private void validateIsThousand(int amount) {
        if(amount % Constant.DIVIDE_UNIT != 0) throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND);
    }

    private void validateIsPositive(int amount){
        if(amount <= 0) throw new IllegalArgumentException(ErrorMessage.AMOUNT_SCOPE);
    }

    public int getAmount() {
        return amount;
    }
}
