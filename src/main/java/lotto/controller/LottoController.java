package lotto.controller;

import lotto.util.ExceptionHandler;
import lotto.validation.InputValidator;
import lotto.view.ConsoleOutput;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        ConsoleOutput.displayUserInputPrompt();
        String input = inputView.getUserPurchaseAmount();
        InputValidator.validateForNonNumericCharacters(input);
        InputValidator.validateNumberLessThan1000(input);
    }
}
