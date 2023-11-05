package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
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
        return Integer.parseInt(input);
    }
    
    private static void validateInputNumber(String input) {
        if (input.matches("\\d*")) return;
        throw new IllegalArgumentException("숫자를 입력해주세요.");
    }
}

