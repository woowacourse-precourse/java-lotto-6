package lotto.controller;

import lotto.domain.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void startGame() {
        inputAmount();
    }

    private static Player inputAmount() {
        try {
            return new Player(InputView.inputAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputAmount();
        }
    }
}
