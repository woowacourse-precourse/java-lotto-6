package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class SplitNumber {
    private static final String NUMBER_REQUIRED = "숫자만 입력 가능합니다";

    public static List<Integer> splitNumber(String inputNumber) {
        List<String> splitedNumber = List.of(inputNumber.split(","));
        if (inputNumber.charAt(inputNumber.length() - 1) == ',') {
            throw new IllegalArgumentException(NUMBER_REQUIRED);
        }

        return parseInteger(splitedNumber);
    }

    private static List<Integer> parseInteger(List<String> splitedNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitedNumber) {
            validateIsNumber(number);
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    private static void validateIsNumber(String number) {
        if (number.matches("[0-9]+") == false) {
            throw new IllegalArgumentException(NUMBER_REQUIRED);
        }
    }
}
