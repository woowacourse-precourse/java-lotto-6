package lotto.controller.user;

import lotto.controller.handler.ExceptionHandler;
import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BonusDraw {
    private final InputView inputView;

    public BonusDraw(InputView inputView) {
        this.inputView = inputView;
    }

    private boolean isCorrectNumber(String number) {
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        try {
            exceptionHandler.handleBonusNumberException(number);
        } catch (IllegalArgumentException exception) {
            inputView.showInputErrorMessage(exception.getMessage());
            return false;
        }

        return true;
    }

    private int inputBonusNumber() {
        String input;

        while (true) {
            inputView.showBonusNumberInputForm();
            input = readLine().trim();
            inputView.endInput();

            if (isCorrectNumber(input)) {
                break;
            }
        }

        return Integer.parseInt(input);
    }

    public void draw() {
        int bonusNumber = inputBonusNumber();
    }
}
