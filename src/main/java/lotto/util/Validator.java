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

    public static int isDivide(int number) {
        if(number % Config.PRICE_UNIT == 0) return number/Config.PRICE_UNIT;
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

    public static void isDuplicatedBonus(List<Integer> numbers, int number) {
        if(numbers.contains(number)) ErrorView.isDuplicatedError();
    }

    public static void isSmallAndBig(int inputNum) {
        if(inputNum < Config.MIN_LOTTO || inputNum > Config.MAX_LOTTO) ErrorView.isSmallAndBigError();
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        isSize(numbers);
        isDuplicated(numbers);
    }

    public static int validateSingleNumber(String inputNum) {
        int number = isNumber(inputNum);
        isSmallAndBig(number);

        return number;
    }


}
