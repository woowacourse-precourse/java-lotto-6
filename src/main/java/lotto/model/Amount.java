package lotto.model;

import static lotto.InputValidator.amountValidator;

public class Amount {

    private final int amount;

    public Amount(String amount){
        this.amount = amountValidator(amount);
    }

    public int getAmount(){
        return amount;
    }

}
