package lotto.controller;

import lotto.domain.PlayerBuyPrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void startGame() {
        inputAmount();
    }

    private static PlayerBuyPrice inputAmount() {
        try {
            return new PlayerBuyPrice(InputView.inputAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputAmount();
        }
    }
}
