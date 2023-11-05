package lotto.view;

import static lotto.constant.ErrorMessage.EXCEEDED_MAXIMUM_NUMBER_FORMAT;
import static lotto.constant.ErrorMessage.INPUT_NOT_DIGIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String IS_NUMBER_REGEX = "\\d*";
    private static final Pattern IS_NUMBER_PATTERN = Pattern.compile(IS_NUMBER_REGEX);

    public Long getPurchaseAmount() {
        String input = readLine().trim();
        validateIsInputDigit(input);
        return convertInputToMoneyFormat(input);
    }

    public void close() {
        Console.close();
    }

    private void validateIsInputDigit(String input) {
        Matcher matcher = IS_NUMBER_PATTERN.matcher(input);
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
