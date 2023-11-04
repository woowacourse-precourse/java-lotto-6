package lotto.utils;

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
}
