package lotto.controller;

import lotto.view.InputView;

public class GameController {
    private final InputView inputView;
    public GameController(InputView inputView) {
        this.inputView = inputView;
    }
    public void startGame() {
        String answer = inputView.readPurchaseAmount();
        System.out.println(answer);
    }
}
