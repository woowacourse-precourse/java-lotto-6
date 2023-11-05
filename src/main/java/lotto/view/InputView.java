package lotto.view;

import static lotto.constant.ErrorMessage.BLANK_INPUT;
import static lotto.constant.ErrorMessage.EXCEEDED_MAXIMUM_NUMBER_FORMAT;
import static lotto.constant.ErrorMessage.INPUT_NOT_DIGIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String REGEXP_ONLY_NUMBER  = "^\\d*$";
    private static final Pattern PATTERN_ONLY_NUMBER = Pattern.compile(REGEXP_ONLY_NUMBER);

    public Long getPurchaseAmount() {
        String input = readLine().trim();
        validateInputBlank(input);
        validateIsInputDigit(input);
        return convertInputToMoneyFormat(input);
    }

    public void close() {
        Console.close();
    }

    private void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT.toString());
        }
    }

    private void validateIsInputDigit(String input) {
        Matcher matcher = PATTERN_ONLY_NUMBER.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_NOT_DIGIT.toString());
        }
    }

    private Long convertInputToMoneyFormat(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEEDED_MAXIMUM_NUMBER_FORMAT.toString());
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
