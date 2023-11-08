package lotto.controller;

import lotto.domain.PlayerBuyPrice;
import lotto.view.InputView;

public class LottoGameController {

    public void startGame() {
        inputAmount();
    }

    private static PlayerBuyPrice inputAmount() {
        try {
            return new PlayerBuyPrice(InputView.inputAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }
}
