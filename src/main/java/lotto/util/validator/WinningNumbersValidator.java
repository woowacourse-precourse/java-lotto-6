package lotto.util.validator;

import java.util.List;

public class WinningNumbersValidator extends LottoValidator {
    private static final String COMMA = ",";

    public static void validate(String input) {
        List<String> winningNumbers = splitByComma(input);
        for (String winningNumber : winningNumbers) {
            validateNumeric(winningNumber);
            validateRange(winningNumber);
        }
    }

    private static List<String> splitByComma(String input) {
        return List.of(removeSpace(input).split(COMMA));
    }

    private static String removeSpace(String input) {
        return input.replace(" ", "");
    }
}
