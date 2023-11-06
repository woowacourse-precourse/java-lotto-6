package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INVALID_INTEGER_INPUT = "[ERROR] 정수만 입력 가능합니다.";

    private InputView() {
    }

    public static int readPurchaseAmount() {
        printInputGuideMessage("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_INPUT);
        }
    }

    public static List<Integer> readWinningNumbers() {
        printInputGuideMessage("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        try {
            return toList(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_INPUT);
        }
    }

    public static int readBonusNumber() {
        printInputGuideMessage("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateContainsBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_INPUT);
        }
    }

    private static void printInputGuideMessage(String message) {
        System.out.println(message);
    }

    private static void validateContainsBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백이 포함되어 있습니다.");
        }
    }

    private static List<Integer> toList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
