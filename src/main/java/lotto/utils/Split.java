package lotto.utils;

import lotto.enums.Messages;

import java.util.ArrayList;
import java.util.List;

public class Split {
    public static List<Integer> splitStringToInteger(String input) {
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            ValidateCheck.pureIntegerCheck(number);
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
