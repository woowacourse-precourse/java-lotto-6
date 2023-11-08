package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.Validator;

public class IntUtil {
    public static List<Integer> makeIntegerNumbers(String numbers) {
        String[] splitNumbers = splitNumbers(numbers);
        List<Integer> integerNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            Validator.isNumber(number);
            integerNumbers.add(makeIntegerNumber(number));
        }
        return integerNumbers;
    }

    public static int makeIntegerNumber(String input) {
        return Integer.parseInt(input);
    }

    public static String[] splitNumbers(String numbers) {
        return numbers.split(",");
    }

    public static double calculateProfit(long profit, int money) {
        return ((double) profit / (double) money) * 100;
    }
}
