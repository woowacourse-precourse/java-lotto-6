package lotto.validation;

import static lotto.exception.GlobalExceptionHandler.handleCustomException;

import lotto.exception.errorzip.*;

import java.util.*;

public class NumberValidation {
    private static final int ONE_THOUSAND = 1000;
    private static final String COMMA_SPLITTER = "([1-9]|[1-3][0-9]|4[0-5]),";
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

    public static void isSixSizeOfList(List<Integer> list){
        if(list.size() != 6){
            handleCustomException(new NotSizeOfList());
        }
    }

    public static void isCommaSplitter(String inputValue){
        if(!inputValue.matches(COMMA_SPLITTER)){
            handleCustomException(new NotCommaSplitter());
        }
    }

}
