package lotto.controller;

import lotto.domain.Amount;
import lotto.view.InputView;

public class GameController {
    private InputView inputView = new InputView();
    private Amount amount;

    public void playGame() {
        amount = repeatInputAmount();
    }

    private Amount repeatInputAmount() {
        while (true) {
            try {
                return new Amount(inputView.inputAmount());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
