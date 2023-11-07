package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String TOO_MANY_MONEY_MESSAGE = "너무 큰 금액을 입력했습니다.";

    private static String getUserInput() {
        return Console.readLine().trim();
    }

    public static List<Integer> getLottoNumbersInput() {
        String userInput = getUserInput();
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(InputView::convertInputToNumber)
                .toList();
    }

    public static int getPaidMoneyInput() {
        String userInput = getUserInput();
        return convertInputToNumber(userInput);
    }

    public static int getBonusNumberInput() {
        String userInput = getUserInput();
        return convertInputToNumber(userInput);
    }

    private static int convertInputToNumber(String input) {
        validateInputNumber(input);
        validateExceedMaximum(input);
        return Integer.parseInt(input);
    }

    private static void validateInputNumber(String input) {
        if (input.matches("\\d*")) return;
        throw new IllegalArgumentException(INPUT_NUMBER_MESSAGE);
    }

    private static void validateExceedMaximum(String input) {
        if (input.length() <= 10 && Long.parseLong(input) <= Integer.MAX_VALUE) return;
        throw new IllegalArgumentException(TOO_MANY_MONEY_MESSAGE);
    }
}

