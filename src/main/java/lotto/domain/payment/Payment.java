package lotto.domain.payment;

import lotto.exception.PaymentException;
import lotto.exception.PaymentExceptionMessage;

public record Payment (int amount) implements PaymentConstant {
    public Payment(int amount){
        validateAmount(amount);
        this.amount = amount;
    }
    private static void validateAmount(int amount){
        validateAmountIsPositiveNumber(amount);
        validateAmountIsAligned(amount);
    }
    private static void validateAmountIsPositiveNumber(int amount){
        if(amount<=0){
            throw new PaymentException(PaymentExceptionMessage.INVALID_VALUE);
        }
    }
    private static void validateAmountIsAligned(int amount){
        if(amount % PAYMENT_UNIT !=0){
            throw new PaymentException(PaymentExceptionMessage.INVALID_AMOUNT);
        }
    }
}
