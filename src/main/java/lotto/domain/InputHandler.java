package lotto.domain;

import java.util.stream.Stream;
import lotto.view.InputView;

public class InputHandler {
    public static String inputWinningNumber() {
        String inputNumber = InputView.inputWinningLottoNumber();

        return inputNumber;
    }

    public static int inputBonusNumber() {
        int bonus = InputView.inputBonusNumber();

        return bonus;
    }

    public static int inptAmountNumber() {
        int amountNumber = InputView.inputAmount();

        return amountNumber;
    }

    private static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean hasEmptySpace(String input) {
        return Stream.of(input)
                .filter(str -> str != null)
                .flatMap(str -> str.chars().mapToObj(ch -> (char) ch))
                .anyMatch(Character::isWhitespace);
    }
}
