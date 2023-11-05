package lotto.domain;

import lotto.exception.PaymentException;
import lotto.exception.PaymentExceptionMessage;

public record Payment (int amount){
    public Payment(int amount){
        validateAmountIsPositiveNumber(amount);
        this.amount = amount;
    }
    public static void validateAmountIsPositiveNumber(int amount){
        if(amount<=0)
            throw new PaymentException(PaymentExceptionMessage.INVALID_VALUE);
    }
}
