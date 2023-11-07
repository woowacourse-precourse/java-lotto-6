package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String POSITIVE_INTEGER_REGEXP = "^[0-9]+$";
    private static final String LONG_PATTERN_MISMATCH_ERROR_MESSAGE = "숫자를 입력해 주세요.";
    public Integer InputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readIntegerLine();
    }

    private Integer readIntegerLine() {
        String input = Console.readLine().trim();
        validateLongPattern(input);
        return Integer.parseInt(input);
    }

    private void validateLongPattern(String input) {
        if (!input.matches(POSITIVE_INTEGER_REGEXP)) {
            throw new IllegalArgumentException(LONG_PATTERN_MISMATCH_ERROR_MESSAGE);
        }
    }
}
