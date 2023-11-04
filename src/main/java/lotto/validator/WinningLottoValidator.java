package lotto.validator;

import java.util.regex.Pattern;

public class WinningLottoValidator {
    public static final String WINNING_NUMBERS_REGEX = "^[0-9,]+$";
    public static final String WRONG_INPUT_WINNING_NUMBERS_MESSAGE =
            "당첨 번호는 숫자와 '" + InputValidator.DELIMITER + "'만을 사용하여 입력해주세요.";


    public static void inputValidate(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(InputValidator.ENTER_VALUE_MESSAGE);
        }

        if (!isMatchedWinningNumbersRegex(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_WINNING_NUMBERS_MESSAGE);
        }
    }

    private static boolean isMatchedWinningNumbersRegex(final String input) {
        return Pattern.matches(WINNING_NUMBERS_REGEX, input);
    }
}
