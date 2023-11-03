package lotto.validator;

import static lotto.enums.AmountEnum.*;

import lotto.exception.IllegalAmountException;
import lotto.exception.IllegalNumberTypeException;

public class NumberValidator {

    public static void validateNumberType(String unprocessedNumbers){
        try{
            Integer.valueOf(unprocessedNumbers);
        }catch (NumberFormatException e){
            throw new IllegalNumberTypeException();
        }
    }
    public static void validateMinimumAmount(Integer amount){

        if(amount % MIN_VALUE.getAmount() != ZERO_VALUE.getAmount()){
            throw new IllegalAmountException();
        }
    }
}
