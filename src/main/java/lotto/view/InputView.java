package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String POSITIVE_INTEGER_REGEXP = "^[0-9]+$";
    private static final String POSITIVE_INTEGER_WITH_COMMA = "^[0-9]+(,[0-9]+)*$";

    private static final String INTEGER_PATTERN_MISMATCH_ERROR_MESSAGE = "숫자를 입력해 주세요.";
    private static final String INTEGER_WITH_COMMA_MISMATCH_ERROR_MESSAGE = "숫자를 쉼표(,)로 구분하여 입력해 주세요.";

    public Integer inputPurchaseAmount() {
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
            throw new IllegalArgumentException(INTEGER_PATTERN_MISMATCH_ERROR_MESSAGE);
        }
    }

    public List<Integer> InputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readIntegersSplitByComma();
    }

    private List<Integer> readIntegersSplitByComma() {
        String input = Console.readLine().trim();
        validateIntegersWithComma(input);
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateIntegersWithComma(String input) {
        if (!input.matches(POSITIVE_INTEGER_WITH_COMMA)) {
            throw new IllegalArgumentException(INTEGER_PATTERN_MISMATCH_ERROR_MESSAGE);
        }
    }

    public Integer InputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readIntegerLine();
    }
}
