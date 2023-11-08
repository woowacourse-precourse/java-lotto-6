package model;

import common.Constant;

public class Amount {

    private final int amount;

    public Amount(int amount){
        validateIsThousand(amount);
        validateIsPositive(amount);
        this.amount = amount;
    }

    private void validateIsThousand(int amount) {
        if(amount % Constant.DIVIDE_UNIT != 0) throw new IllegalArgumentException();
    }

    private void validateIsPositive(int amount){
        if(amount <= 0) throw new IllegalArgumentException();
    }

    public int getAmount() {
        return amount;
    }
}
