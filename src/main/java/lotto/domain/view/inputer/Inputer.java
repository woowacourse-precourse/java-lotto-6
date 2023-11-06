package lotto.domain.view.inputer;

import java.util.List;
import lotto.domain.util.validator.InputValidator;
import lotto.domain.view.inputer.manager.InputManager;
import lotto.domain.view.printer.InputPrinter;

public class Inputer {
    private Inputer() {
    }

    public static Integer inputPurchaseAmount() {
        while (true) {
            try {
                InputPrinter.printPurchaseAmount();
                String userInput = InputManager.getReadLineWithTrim();
                InputValidator.validateNumber(userInput);

                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                InputPrinter.printWinningNumbers();
                String userInput = InputManager.getReadLineWithTrim();
                InputValidator.validateNumberOrComma(userInput);

                return InputManager.getNumbersByInput(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static Integer inputBonusNumber() {
        while (true) {
            try {
                InputPrinter.printBonusNumber();
                String userInput = InputManager.getReadLineWithTrim();
                InputValidator.validateNumber(userInput);

                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
