package lotto.validation;

import lotto.exception.CustomException;
import lotto.exception.ErrorCode;
import lotto.exception.GlobalExceptionHandler;

public class NumberValidation {
    public static int isDivisible(int inputValue){
        if(inputValue%1000 != 0){
            GlobalExceptionHandler.handleCustomException(new CustomException(ErrorCode.NOT_DIVISIBLE_BY_1000));
        }
        System.out.println();
        return inputValue/1000;
    }
}
