package lotto.utils.validator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersValidator {

    private WinningNumbersValidator() {
    }

    public static void validate(String inputValue) {
        validateCommaPosition(inputValue);
        validateNumberFormat(inputValue);
    }

    private static void validateCommaPosition(String inputValue) {
        if (inputValue.startsWith(",") || inputValue.endsWith(",")) {
            throw new IllegalArgumentException("콤마 위치");
        }
    }

    private static void validateNumberFormat(String inputValue) {
        List<String> numbers = new ArrayList<>(List.of(inputValue.split(",")));
        try {
            stringToInt(numbers);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자");
        }

    }

    private static void stringToInt(List<String> numbers) {
        numbers.stream()
                .forEach((number) -> Integer.parseInt(number));
    }
}
