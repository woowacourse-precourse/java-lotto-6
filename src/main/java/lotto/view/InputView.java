package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private InputView() {
    }

    public static int readPurchaseAmount() {
        printInputGuideMessage("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }

    public static List<Integer> readWinningNumbers() {
        printInputGuideMessage("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        try {
            return toList(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }

    public static int readBonusNumber() {
        printInputGuideMessage("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }

    private static void printInputGuideMessage(String message) {
        System.out.println(message);
    }

    private static void validateContainsBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_BLANK_INPUT.getMessage());
        }
    }

    private static List<Integer> toList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
