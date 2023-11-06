package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.constants.ErrorMessage;

public class InputView {

    private static final Pattern WINNING_NUMBERS_REGEX = Pattern.compile("^\\d+(?:,\\d+)*$");

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

    public static String[] readWinningNumbers() {
        printInputGuideMessage("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumbersRegex(input);
        validateContainsBlank(input);
        return input.split(",");
    }

    private static void validateNumbersRegex(String input) {
        if (invalidNumbersRegex(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_REGEX_INPUT.getMessage());
        }
    }

    private static boolean invalidNumbersRegex(String input) {
        return !WINNING_NUMBERS_REGEX.matcher(input).matches();
    }

    public static String readBonusNumber() {
        printInputGuideMessage("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        return input;
    }
}
