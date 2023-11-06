package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.config.Config;
import lotto.view.ErrorView;

public class Validator {

    public static int isNumber(String inputNum) {
        try {
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            return ErrorView.isNumberError();
        }
    }

    public static int isDivide(int inputNum) {
        if(inputNum % Config.PRICE_UNIT == 0) return inputNum/Config.PRICE_UNIT;
        return ErrorView.isDivideError();
    }

    public static void isSize(List<Integer> numbers) {
        if(numbers.size() != Config.COUNT_LOTTO) {
            ErrorView.isSizeError();
        }
    }

    public static void isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int number : numbers) {
            if(uniqueNumbers.contains(number)) {
                ErrorView.isDuplicatedError();
            }
            uniqueNumbers.add(number);
        }
    }

    public static void isDuplicatedBonus(List<Integer> numbers, int num) {
        if(numbers.contains(num)) ErrorView.isDuplicatedError();
    }

    public static void isSmallAndBig(int inputNum) {
        if(inputNum < Config.MIN_LOTTO || inputNum > Config.MAX_LOTTO) ErrorView.isSmallAndBigError();
    }



}
