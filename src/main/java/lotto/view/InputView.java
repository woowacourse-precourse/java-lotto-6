package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class InputView {
    private static final String ERROR_ISSTRING = "[ERROR] 숫자만 입력해 주세요.";

    private static final String ERROR_ISBLANK ="[ERROR] 입력값을 입력해주세요.";

    private static final String ERROR_START_OR_END_WITH_DELIMITER = "[ERROR] 델리미터로 시작하거나 끝나면 안 됩니다.";
    private static final String ERROR_DELIMITER_WITH_BLANK = "[ERROR] 연속된 델리미터 또는 델리미터와 공백이 포함되어 있으면 안 됩니다.";

    private static final String TOTAL_COST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final String DELIMITER = ",";
    static final String SPACE = " ";

    public static int totalCost() {
        System.out.println(TOTAL_COST);
        return parseToInt(input());
    }

    public static List<Integer> winningNumber() {
        System.out.println(WINNING_NUMBER);
        return splitInput(input());
    }

    public static int bonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER);
        return parseToInt(input());
    }

    private static String input() {
        String input = Console.readLine();
        isBlank(input);
        return input;
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ISSTRING);
        }
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_ISBLANK);
        }
    }

    private static List<Integer> splitInput(String input) {
        validateDelimiter(input);
        String[] inputParts = input.split(DELIMITER);
        List<Integer> result = new ArrayList<>();

        for (String part : inputParts) {
            result.add(parseToInt(part));
        }
        return result;
    }

    private static void validateDelimiter(String input) {
        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_START_OR_END_WITH_DELIMITER);
        }
        if (input.contains(DELIMITER + DELIMITER) || input.contains(DELIMITER + SPACE)) {
            throw new IllegalArgumentException(ERROR_DELIMITER_WITH_BLANK);
        }
    }
}