package lotto.validator;

import static lotto.enums.AmountEnum.*;

import lotto.exception.IllegalAmountException;

public class NumberValidator {
    public static void validateMinimumAmount(Integer amount){

        if(amount % MIN_VALUE.getAmount() != ZERO_VALUE.getAmount()){
            throw new IllegalAmountException();
        }
    }
}
