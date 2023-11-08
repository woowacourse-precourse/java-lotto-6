package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class SplitNumber {
    private static final String NOT_A_NUMBER_MESSAGE = "입력은 숫자여야 합니다";
    private static final String UNDER_20_BILLION_REQUIRED = "입력은 20억 이하여야 합니다";
    private static final String NUMBER_REGEX = "[0-9]+";

    private SplitNumber() {
    }

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

        validateIsUnder20Billion(number);
    }

    private static void validateIsUnder20Billion(String input) {
        if (input.length() > 10) {
            throw new IllegalArgumentException(UNDER_20_BILLION_REQUIRED);
        }

        try {
            int number = Integer.parseInt(input);
            if (number > 2000000000) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UNDER_20_BILLION_REQUIRED);
        }
    }
}
