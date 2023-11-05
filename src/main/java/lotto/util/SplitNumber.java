package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class SplitNumber {
    private static final String NOT_A_NUMBER_MESSAGE = "입력은 숫자여야 합니다";
    private static final String NUMBER_REGEX = "[0-9]+";

    public static List<Integer> splitNumber(String inputNumber) {
        List<String> splitedNumber = List.of(inputNumber.split(","));
        if (inputNumber.charAt(inputNumber.length() - 1) == ',') {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
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
        if (number.matches(NUMBER_REGEX) == false) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
    }
}
