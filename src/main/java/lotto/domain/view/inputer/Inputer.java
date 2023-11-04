package lotto.domain.view.inputer;

import java.util.List;
import lotto.domain.util.validator.InputValidator;
import lotto.domain.view.inputer.manager.InputManager;
import lotto.domain.view.printer.InputPrinter;

public class Inputer {
    public static Integer inputPurchaseAmount() {
        InputPrinter.printPurchaseAmount();
        String userInput = InputManager.getReadLineWithTrim();
        InputValidator.validateNumber(userInput);

        return Integer.parseInt(userInput);
    }

    public static List<Integer> inputWinningNumbers() {
        InputPrinter.printWinningNumbers();
        String userInput = InputManager.getReadLineWithTrim();

        return InputManager.getNumbersByInput(userInput);
    }

    public static Integer inputBonusNumber() {
        InputPrinter.printBonusNumber();
        String userInput = InputManager.getReadLineWithTrim();
        InputValidator.validateNumber(userInput);

        return Integer.parseInt(userInput);
    }
}
