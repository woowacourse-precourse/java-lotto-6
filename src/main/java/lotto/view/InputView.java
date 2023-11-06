package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    private InputView() {
    }

    public static String inputPurchasePrice() {
        String purchasePrice = AddNewLineAfterReadLine();
        InputValidator.validatePurchasePrice(purchasePrice);
        return purchasePrice;
    }

    public static String inputWinningNumber() {
        String winningNumber = AddNewLineAfterReadLine();
        InputValidator.validateWinningNumber(winningNumber);
        return winningNumber;
    }

    public static String inputBonusNumber() {
        String bonusNumber = AddNewLineAfterReadLine();
        InputValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private static String AddNewLineAfterReadLine() {
        String input = Console.readLine();
        OutputView.printNewLine();
        return input;
    }
}
