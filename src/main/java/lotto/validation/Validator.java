package lotto.validation;

import lotto.view.ErrorMessage;

import java.util.List;

public class Validator {

    private static final int MAX_NUMBER_LENGTH = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;


    public boolean isValidLength(List<String> list){
        if(list.size() != MAX_NUMBER_LENGTH){
            ErrorMessage.lengthErrorMessage(MAX_NUMBER_LENGTH);
            throw new IllegalArgumentException();
        }
        return true;
    }

    public void isValidRangeNumberInList(List<Integer> numbers, int start, int end){
        for(int number : numbers){
            isValidNumberInRange(number,start,end);
        }
    }
    public boolean isValidNumberInRange(int number, int start, int end){
        start = START_NUMBER;
        end = END_NUMBER;
        if(number < start || number > end){
            ErrorMessage.outOfRangeErrorMessage(start,end);
            throw new IllegalArgumentException();
        }return true;
    }

    public void isValidIntegerNumberInList(List<String> list){
        for(String number : list){
            isNumberCharInteger(number);
        }
    }

    public boolean isNumberCharInteger(String input){
        for(char c : input.toCharArray()){
            if(!Character.isDigit(c)){
                ErrorMessage.numberCharErrorMessage();
                throw new IllegalArgumentException();
            }
        }
        return true;
    }



}
