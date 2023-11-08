package lotto.controller;

import lotto.view.ExceptionMessage;

import java.util.List;

public class NumberValidator {
    public static void isDivisible(String input) {
        int money = Integer.parseInt(input);
        if(money % 1000 != 0){
            String msg = ExceptionMessage.divisibleException();
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isNumber(String input) {
        String regex = "^[0-9]+$";
        if(!input.matches(regex)){
            String msg = ExceptionMessage.numberException();
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isDuplicated(String input, List<Integer> winningNumbers) {
        int num = Integer.parseInt(input);
        if(winningNumbers.contains(num)){
            String msg = ExceptionMessage.duplicatedNumberException();
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isProperRange(String input) {
        int num = Integer.parseInt(input);
        if(num < 1 || num > 45){
            String msg = ExceptionMessage.rangeException();
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isNaturalNumber(String input) {
        int num = Integer.parseInt(input);
        if(num < 0){
            String msg = ExceptionMessage.notNaturalNumberException();
            throw new IllegalArgumentException(msg);
        }
    }
}
