package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.ValidationUtils;

public class InputView {

    public static int readPurchaseAmount() {
        OutputView.printLottoPurchaseAmountPrompt();
        String input = Console.readLine();
        ValidationUtils.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        OutputView.printWinningNumbersPrompt();
        String input = Console.readLine();
        validateWinningNumbers(input);
        return Arrays.stream(input.split(","))
            .map(Integer::parseInt)
            .toList();
    }

    public static int readBonusNumber() {
        OutputView.printBonusNumberPrompt();
        String input = Console.readLine();
        ValidationUtils.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    private static void validateWinningNumbers(String input) {
        ValidationUtils.validateNotNull(input);
        validateNotStartOrEndWithComma(input);
        validateNoConsecutiveCommas(input);
        validateNoCommasWithSpaces(input);
        validateNoSpecialCharactersExceptComma(input);
    }

    private static void validateNotStartOrEndWithComma(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("입력의 시작이나 끝에 쉼표가 있습니다");
        }
    }

    private static void validateNoConsecutiveCommas(String input) {
        if (input.contains(",,") || input.contains(", ,")) {
            throw new IllegalArgumentException("쉼표가 연속해서 있습니다");
        }
    }

    private static void validateNoCommasWithSpaces(String input) {
        if (input.contains(" ,") || input.contains(", ")) {
            throw new IllegalArgumentException("쉼표 옆에 공백이 있습니다");
        }
    }

    private static void validateNoSpecialCharactersExceptComma(String input) {
        if (input.matches(".*[^0-9,\\s]+.*")) {
            throw new IllegalArgumentException("쉼표를 제외한 특수문자가 있습니다");
        }
    }
}
