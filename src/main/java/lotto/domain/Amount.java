package lotto.domain;

import java.util.List;
import lotto.message.ExceptionMessage;

public class Amount {

    private final int AMOUNT_MIN = 1000;
    private final int amount;

    public Amount(int amount){
        validateMin(amount);
        validateDivision(amount);

        this.amount = amount;
    }

    private void validateMin(int amount) {
        if (amount<AMOUNT_MIN) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_MIN.getMessage());
        }
    }

    private void validateDivision(int amount){
        if(amount%AMOUNT_MIN != 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_DIVISION.getMessage());
        }
    }

    public int calculatePurchaseCount(int amount){
        return amount/AMOUNT_MIN;
    }

    public int getAmount(){
        return amount;
    }
}
