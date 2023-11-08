package lotto.validation;

import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Validator {


    private static final int MAX_NUMBER_LENGTH = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private static final int DIVISOR = 1000;

    public List<Integer> isValidWinningNumbers(List<Integer> winningNumbers){
        isValidLength(winningNumbers);
        isDuplicateNumberInList(winningNumbers);
        isValidRangeNumberInList(winningNumbers);
        return winningNumbers;
    }


    public void isValidBonusNumber(List<Integer> winningNumbers, int bonusNumber){
        isValidNumberInRange(bonusNumber);
        isDuplicateNumber(winningNumbers,bonusNumber);
    }

    public boolean isValidLength(List<Integer> list){
        if(list.size() != MAX_NUMBER_LENGTH){
            ErrorMessage.lengthErrorMessage(MAX_NUMBER_LENGTH);
            throw new IllegalArgumentException();
        }
        return true;
    }

    public void isValidRangeNumberInList(List<Integer> numbers){
        for(int number : numbers){
            isValidNumberInRange(number);
        }
    }
    public boolean isValidNumberInRange(int number){
        int start = START_NUMBER;
        int end = END_NUMBER;
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

    public boolean  isNumberCharInteger(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            ErrorMessage.numberCharErrorMessage();
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isMultipleNumber(int number){
        int divisor = DIVISOR;
        if(number < divisor || number % divisor != 0){
            ErrorMessage.multipleErrorMessage(divisor);
            throw new IllegalArgumentException();
        }
        return true;
    }

    //당첨값 입력시 적용
    public boolean isDuplicateNumberInList(List<Integer> list){
        HashSet<Integer> set = new HashSet<>(list);
        if(list.size() != set.size()){
            ErrorMessage.duplicatedNumberInListError();
            throw new IllegalArgumentException();
        }
        return true;

    }
    //보너스값 넣을때 사용
    public boolean isDuplicateNumber(List<Integer>list, int number){
        if(list.contains(number)){
            ErrorMessage.duplicateErrorMessage();
            throw new IllegalArgumentException();
        }
        return true;
    }


}
