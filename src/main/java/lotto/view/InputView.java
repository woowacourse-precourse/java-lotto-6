package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;

public class InputView {

    private InputView() {
    }

    public static String readPurchaseAmount() {
        printInputGuideMessage("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        return input;
    }

    private static void printInputGuideMessage(String message) {
        System.out.println(message);
    }

    private static void validateContainsBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_BLANK_INPUT.getMessage());
        }
    }

    public static String readWinningNumbers() {
        printInputGuideMessage("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        return input;
    }

    public static String readBonusNumber() {
        printInputGuideMessage("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        return input;
    }
}
