package domain;

import static util.ErrorMessage.CANT_DIVIDE_AMOUNT;
import static util.ErrorMessage.NOT_POSITIVE_AMOUNT;
import static view.InputView.inputLottoPurchaseAmount;

public class Amount{
    private final int amount;
    private final int LOTTO_TICKET_PRICE = 1000;
    public Amount(int amount){
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if(!validateIsPositive(amount) || !validateIsDivisible(amount)){
            inputLottoPurchaseAmount();
        }
    }

    private boolean validateIsPositive(int amount) {
        try{
            if(amount <= 0){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println(NOT_POSITIVE_AMOUNT.getErrorMessage());
            return false;
        }
        return true;
    }

    private boolean validateIsDivisible(int amount) {
        try {
            if (amount % LOTTO_TICKET_PRICE != 0) {
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e) {
            System.out.println(CANT_DIVIDE_AMOUNT.getErrorMessage());
            return false;
        }
        return true;
    }
}

