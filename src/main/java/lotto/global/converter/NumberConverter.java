package lotto.global.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberConverter {
    private static final String SEPARATOR = ",";

    public static List<Integer> convertToNumbers(String inputNumbers) {
        String[] numbers = validateInputNumbersSeparatedByCommas(inputNumbers);
        validateInputNumbersAreNumber(numbers);

        return Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] validateInputNumbersSeparatedByCommas(String inputNumbers) {
        try {
            return inputNumbers.split(SEPARATOR);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 입력 시 , 로 구분지어 입력하셔야 합니다.");
        }
    }

    private static void validateInputNumbersAreNumber(String[] numbers) {
        try {
            Arrays.stream(numbers)
                    .map(String::trim)
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    public static Integer convertToNumber(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
}
