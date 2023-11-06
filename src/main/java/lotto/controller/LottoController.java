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
        getUserInputAndValidate();
    }

    private void getUserInputAndValidate() {
        ConsoleOutput.displayUserInputPrompt();
        try {
            String input = inputView.getUserPurchaseAmount();
            InputValidator.validateUserInput(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getUserInputAndValidate();
        }
    }
}
