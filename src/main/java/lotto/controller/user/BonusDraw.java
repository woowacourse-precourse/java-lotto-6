package lotto.controller.user;

import lotto.controller.handler.ExceptionHandler;
import lotto.domain.Lotto;
import lotto.view.InputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BonusDraw {
    private int bonusNumber;
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

    public void draw() {
        String input;

        while (true) {
            inputView.showBonusNumberInputForm();
            input = readLine().trim();
            inputView.endInput();

            if (isCorrectNumber(input)) {
                break;
            }
        }

        bonusNumber = Integer.parseInt(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
