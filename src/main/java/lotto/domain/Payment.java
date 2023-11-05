package lotto.domain;

import lotto.domain.constant.PaymentConstant;
import lotto.exception.PaymentException;
import lotto.exception.PaymentExceptionMessage;

public record Payment (int amount) implements PaymentConstant {
    public Payment(int amount){
        validateAmountIsPositiveNumber(amount);
        validateAmountIsAligned(amount);
        this.amount = amount;
    }
    public static void validateAmountIsPositiveNumber(int amount){
        if(amount<=0){
            throw new PaymentException(PaymentExceptionMessage.INVALID_VALUE);
        }
    }
    public static void validateAmountIsAligned(int amount){
        if(amount % PAYMENT_UNIT !=0){
            throw new PaymentException(PaymentExceptionMessage.INVALID_AMOUNT);
        }
    }
}
