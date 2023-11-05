package lotto.view.validator;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.GameTextConfig.LOTTO_NUMBER_SEPARATOR;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_EMPTY;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_LOTTO_LENGTH;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_NUMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final int INPUT_SEPARATOR_COUNT = (LOTTO_NUMBER_COUNT.getNumber() - 1) * LOTTO_NUMBER_SEPARATOR.getText().length();
    private InputValidator() {}

    public static void validateWinningNumber(String input) {
        checkEmpty(input);
        checkSeparatorCount(input);
    }

    private static void checkSeparatorCount(String input) {
        Pattern pattern = Pattern.compile(LOTTO_NUMBER_SEPARATOR.getText());
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        if (count != INPUT_SEPARATOR_COUNT) {
            throw new IllegalArgumentException(VALIDATE_INPUT_LOTTO_LENGTH.getMessage());
        }
    }

    public static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_INPUT_EMPTY.getMessage());
        }
    }

    public static void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_INPUT_NUMBER.getMessage());
        }
    }


}
