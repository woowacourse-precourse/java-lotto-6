package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LONG_LINE_REGEXP = "^[0-9]+$";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LONG_PATTERN_MISMATCH_ERROR_MESSAGE = "숫자를 입력해 주세요.";
    public Long InputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLongLine();
    }

    private Long readLongLine() {
        String input = Console.readLine();
        validateLongPattern(input);
        return Long.parseLong(input);
    }

    private void validateLongPattern(String input) {
        if (!input.matches(LONG_LINE_REGEXP)) {
            throw new IllegalArgumentException(ERROR_PREFIX + LONG_PATTERN_MISMATCH_ERROR_MESSAGE);
        }
    }
}
