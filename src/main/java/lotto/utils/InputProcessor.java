package lotto.utils;

import java.util.List;
import lotto.validator.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputProcessor {

    public static int processPurchaseAmount() {
        OutputView.printPurchaseAmountPrompt();
        try {
            String input = InputView.getInput();
            InputValidation.validateNumeric(input);
            return InputConverter.convertToNumber(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static List<Integer> processWinningNumbers() {
        OutputView.printWinningNumbersPrompt();
        try {
            String input = InputView.getInput();
            List<String> parsedInput = InputParser.splitByDelimiter(input);
            InputValidation.validateAllNumeric(parsedInput);
            return InputConverter.convertToNumbers(parsedInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int processBonusNumber() {
        OutputView.printBonusNumberPrompt();
        try {
            String input = InputView.getInput();
            InputValidation.validateNumeric(input);
            return InputConverter.convertToNumber(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
