package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.response.Exception;

import java.util.regex.Pattern;

public class InputView {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    private void validateNullAndBlank(String input, Exception exception) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
    private void validateNumeric(String input, Exception exception) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNullAndBlank(input, Exception.MONEY_NULL_BLANK);
        validateNumeric(input, Exception.MONEY_NUMERIC);
        return Integer.parseInt(input);
    }
}
