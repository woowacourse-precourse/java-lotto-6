package lotto.utils;

import lotto.validate.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    public static List<Integer> toList(String inputValue) {
        String[] split = inputValue.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : split) {
            numbers.add(toInteger(number));
        }
        return numbers;
    }

    public static int toInteger(String inputValue) {
        NumberValidator.isNumber(inputValue);
        return Integer.parseInt(inputValue);
    }
}
