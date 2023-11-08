package lotto.validation;

import static lotto.exception.GlobalExceptionHandler.handleCustomException;

import lotto.exception.errorzip.NotAllNumber;
import lotto.exception.errorzip.NotDivisible;
import java.util.*;
import lotto.exception.errorzip.NotSameNumberInList;

public class NumberValidation {
    private static final int ONE_THOUSAND = 1000;
    private static final String NUMBER = "[0-9]";
    public static void isDivisible(int inputValue){
        if(inputValue% ONE_THOUSAND != 0){
            handleCustomException(new NotDivisible());
        }
    }

    public static void isDistinct(List<Integer> inputValue){
        if(inputValue.stream().distinct().count() != inputValue.size()){
            handleCustomException(new NotSameNumberInList());
        }
    }

    public static void isAllNumber(String inputValue){
        for(int i=0;i<inputValue.length();i++){
            if(!Character.isDigit(inputValue.charAt(i))){
                handleCustomException(new NotAllNumber());
            }
        }
    }

}
