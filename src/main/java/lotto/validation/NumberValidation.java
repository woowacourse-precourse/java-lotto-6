package lotto.validation;

import static lotto.exception.GlobalExceptionHandler.handleCustomException;

import lotto.exception.errorzip.*;
import lotto.parsing.Parsing;

import java.util.*;
import java.util.stream.Collectors;

public class NumberValidation {
    private static final int ONE_THOUSAND = 1000;
    private static final String COMMA_SPLITTER = "^(\\d+,)+\\d+$";
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_LIST_SIZE = 6;
    public static void isDivisible(int inputValue){
        if(inputValue% ONE_THOUSAND != 0){
            handleCustomException(new NotDivisible());
        }
    }

    public static void isDistinct(List<Integer> inputValue){
        if(inputValue.stream().distinct().count() != inputValue.size()){
            handleCustomException(new NotSameNumberInGroup());
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
        if(list.size() != LOTTO_LIST_SIZE){
            handleCustomException(new NotSizeOfList());
        }
    }

    public static void isCommaSplitter(String inputValue){
        if(!inputValue.matches(COMMA_SPLITTER)){
            handleCustomException(new NotCommaSplitter());
        }
    }

    public static void isACorrectNumber(String inputValue){
        if(!inputValue.isEmpty() || !inputValue.isBlank()){
            handleCustomException(new NotAllNumber());
        }
    }

    public static void isCorrectNumber(String[] inputValue){
        List<String> collect = Arrays.stream(inputValue).filter(s -> s.isBlank() || s.isEmpty()).toList();
        if(!collect.isEmpty()){
            handleCustomException(new NotAllNumber());
        }
    }

    public static void isACorrectRange(int inputValue){
        if(inputValue < START_NUMBER || inputValue > END_NUMBER){
            handleCustomException(new NotInRange());
        }
    }

    public static void isCorrectRange(List<Integer> inputValue){
        if(!inputValue.stream().allMatch(number -> number>=START_NUMBER && number<=END_NUMBER)){
            handleCustomException(new NotInRange());
        }
    }

    public static void isAllUnique(List<Integer> inputValue, String number){
        if(!inputValue.stream().allMatch(listNum -> listNum!= Parsing.stringToInt(number))){
            handleCustomException(new NotSameNumberInGroup());
        }
    }

}
