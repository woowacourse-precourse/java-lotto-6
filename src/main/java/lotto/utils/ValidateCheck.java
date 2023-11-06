package lotto.utils;

import lotto.enums.Constants;

import java.util.List;

public class ValidateCheck {
    public static void numberCountValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void numberDupulicationValidate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

    public static boolean pureIntegerCheck(String number){
        try {
            int convertNumber = Integer.parseInt(number);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean inputAmountValidate(int amount){
        return amount%Constants.LOTTO_PRICE.getNumber()==0;
    }
}
