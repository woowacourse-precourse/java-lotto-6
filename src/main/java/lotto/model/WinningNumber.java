package lotto.model;

import java.util.regex.Pattern;

public class WinningNumber {

    private static final Pattern winningNumberInputPattern = Pattern.compile("\\d,\\d,\\d,\\d,\\d,\\d");

    public void inputWinningNumber(String input) {
        validateWinningNumber(input);
    }

    private static void validateWinningNumber(String input) {
        if (!winningNumberInputPattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 당첨 번호 입력 양식입니다.");
        }
    }
}
