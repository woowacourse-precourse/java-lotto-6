package lotto.utils.validator;

import static lotto.ErrorMessageConstants.COMMA_POSITION_ERROR_MESSAGE;
import static lotto.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.ErrorMessageConstants.NUMBER_FORMAT_ERROR_MESSAGE;

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
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + COMMA_POSITION_ERROR_MESSAGE);
        }
    }

    private static void validateNumberFormat(String inputValue) {
        List<String> numbers = new ArrayList<>(List.of(inputValue.split(",")));
        try {
            stringToInt(numbers);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void stringToInt(List<String> numbers) {
        numbers.stream()
                .forEach((number) -> Integer.parseInt(number));
    }
}
