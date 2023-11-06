package lotto.controller;

import lotto.domain.Player;
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
        getUserInput();
    }

    private void getUserInput() {
        String input;
        while (true) {
            ConsoleOutput.displayUserInputPrompt();
            input = inputView.getUserPurchaseAmount();
            if (isValidInput(input)) {
                break;
            }
        }
        setPlayerVariableValue(input);
    }

    private boolean isValidInput(String input) {
        try {
            InputValidator.validateUserInput(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void setPlayerVariableValue(String input) {
        Player player = new Player(input);
        player.divideMoneyByThousand();
    }
}
