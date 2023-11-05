package lotto.utils;

import static lotto.utils.constants.ErrorMessageConstants.COMMA_POSITION_ERROR_MESSAGE;
import static lotto.utils.constants.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.constants.ErrorMessageConstants.NUMBER_FORMAT_ERROR_MESSAGE;
import static lotto.utils.Converter.stringToInt;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersValidator {

    private WinningNumbersValidator() {
    }

    public static void validateMainNumbers(String inputValue) {
        validateCommaPosition(inputValue);
        validateMainNumbersFormat(inputValue);
    }

    private static void validateCommaPosition(String inputValue) {
        if (inputValue.startsWith(",") || inputValue.endsWith(",")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + COMMA_POSITION_ERROR_MESSAGE);
        }
    }

    private static void validateMainNumbersFormat(String inputValue) {
        List<String> numbers = new ArrayList<>(List.of(inputValue.split(",")));
        try {
            stringToInt(numbers);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateBonusNumber(String inputBonusNumber) {
        validateBonusNumberFormat(inputBonusNumber);
    }

    private static void validateBonusNumberFormat(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD+NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

}
