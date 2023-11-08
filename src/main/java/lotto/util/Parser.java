package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Validator.NumberValidator;

public class Parser {
    public static int toInteger(String input) {
        NumberValidator.isBlank(input);
        NumberValidator.isNegative(input);
        NumberValidator.isWrongType(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntegerList(String input) {
        List<Integer> result = new ArrayList<>();
        List<String> numbers = Arrays.asList(input.split(","));
        for (String number : numbers) {
            NumberValidator.isBlank(number);
            NumberValidator.isWrongType(number);
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
