package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    private InputView() {
    }

    public static String inputPurchasePrice() {
        String input = AddNewLineAfterReadLine();
        InputValidator.validatePurchasePrice(input);
        return input;
    }

    public static String inputWinningNumber() {
        String input = AddNewLineAfterReadLine();
        InputValidator.validateWinningNumber(input);
        return input;
    }

    public static String inputBonusNumber() {
        String input = AddNewLineAfterReadLine();
        InputValidator.validateBonusNumber(input);
        return input;
    }

    private static String AddNewLineAfterReadLine() {
        String input = Console.readLine();
        OutputView.printNewLine();
        return input;
    }
}
