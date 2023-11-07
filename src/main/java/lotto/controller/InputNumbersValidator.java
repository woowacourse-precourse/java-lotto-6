package lotto.controller;

import lotto.view.ExceptionMessage;

import java.util.HashSet;
import java.util.List;

public class InputNumbersValidator {

    public static void isDuplicated(List<Integer> winningNumbers) {
        HashSet<Integer> hs = new HashSet<>(winningNumbers);
        if(hs.size() != 6){
            String msg = ExceptionMessage.duplicatedNumberException();
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isNumbers(List<Integer> winningNumbers) {
        String regex = "^[0-9]+$";
        for(Integer number : winningNumbers){
            String str = String.valueOf(number);
            if(!str.matches(regex)){
                String msg = ExceptionMessage.numberException();
                throw new IllegalArgumentException(msg);
            }
        }
    }

    public static void isSizeSix(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6){
            String msg = ExceptionMessage.sizeException();
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isPrperRange(List<Integer> winningNumbers) {
        for(Integer number : winningNumbers){
            if(number < 1 || number > 45){
                String msg = ExceptionMessage.rangeException();
                throw new IllegalArgumentException(msg);
            }
        }
    }

    public static void isNaturalNumbers(List<Integer> winningNumbers) {
        for(Integer number : winningNumbers){
            if(number < 0){
                String msg = ExceptionMessage.notNaturalNumberException();
                throw new IllegalArgumentException(msg);
            }
        }
    }
}
