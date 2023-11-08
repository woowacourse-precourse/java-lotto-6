package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class InputView {
    private static final String TOTAL_COST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final String DELIMITER = ",";

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
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값을 입력해주세요.");
        }
    }

    private static List<Integer> splitInput(String input) {
        String[] inputParts = input.split(DELIMITER);
        List<Integer> result = new ArrayList<>();

        for (String part : inputParts) {
            result.add(parseToInt(part));
        }
        return result;
    }
}