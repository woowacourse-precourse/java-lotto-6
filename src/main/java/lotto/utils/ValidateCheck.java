package lotto.utils;

import lotto.enums.Constants;
import lotto.enums.Messages;

import java.util.List;

public class ValidateCheck {
    public static void numberCountValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Messages.NUMBER_COUNT_ERROR_MESSAGE.getMessage());
        }
    }

    public static void numberDupulicationValidate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(Messages.Number_DUPULICATE_MESSAGE.getMessage());
        }
    }

    public static void numbersRangeValidate(List<Integer> numbers) {
        for(int number : numbers){
            if(number<1 || number>45){
                throw new IllegalArgumentException(Messages.NUMBER_RANGE_ERROR_MESSAGE.getMessage());
            }
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
