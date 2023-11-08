package lotto.view;

import static lotto.exception.ErrorMessage.VALIDATE_INPUT_EMPTY;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_NUMBER;
import static lotto.view.constants.OutputMessage.INPUT_BONUS_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputBonusNumberView {

    private InputBonusNumberView() {
    }

    public static int inputBonusNumber() {
        OutputView.printNewLine();
        OutputView.printMessage(INPUT_BONUS_NUMBER_MESSAGE.getMessage());

        String input = Console.readLine();
        return parseBonusNumber(input);
    }

    private static int parseBonusNumber(String input) {
        validateBonusNumber(input);
        return parseInt(input);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_INPUT_NUMBER.getMessage());
        }
    }

    private static void validateBonusNumber(String input) {
        checkEmpty(input);
    }

    private static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_INPUT_EMPTY.getMessage());
        }
    }
}
