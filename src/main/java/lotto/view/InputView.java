package lotto.view;

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
            throw new IllegalArgumentException();
        }
    }

    private Long convertInputToMoneyFormat(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
