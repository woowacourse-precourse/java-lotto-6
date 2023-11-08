package lotto.validation;

import static lotto.exception.GlobalExceptionHandler.handleCustomException;

import lotto.exception.errorzip.NotDivisible;
import java.util.*;
import lotto.exception.errorzip.NotSameNumberInList;

public class NumberValidation {
    public static void isDivisible(int inputValue){
        if(inputValue%1000 != 0){
            handleCustomException(new NotDivisible());
        }
    }

    public static void isDistinct(List<Integer> inputValue){
        if(inputValue.stream().distinct().count() != inputValue.size()){
            handleCustomException(new NotSameNumberInList());
        }
    }

}
