package lotto.controller;

import java.util.List;
import lotto.model.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumberController {
    OutputView outputView = new OutputView();

    public List<Integer> setWinningNumber() {
        String winningNumber;
        while (true) {
            try {
                outputView.printInsertWinningNumber();
                winningNumber = InputView.insertWinningNumber();
                new WinningNumberValidator(winningNumber);
                return InputView.convertToList(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
