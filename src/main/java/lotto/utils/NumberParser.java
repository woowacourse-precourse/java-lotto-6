package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    public static List<Integer> toList(String inputValue) {
        String[] split = inputValue.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : split) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public static int toInteger(String inputValue) {
        return Integer.parseInt(inputValue);
    }
}
