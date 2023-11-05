package lotto.controller;

import lotto.service.GameService;
import lotto.view.InputView;

public class GameMainController {

    private final GameService gameService;
    private final InputView inputView;

    public GameMainController(GameService gameService, InputView inputView) {
        this.gameService = gameService;
        this.inputView = inputView;
    }

    public void run() {
    }

    private void startGame() {
        String purchaseAmount = inputView.inputPurchaseAmount();
        String winningNumber = inputView.inputWinningNumber();
        String bonusNumber = inputView.inputBonusNumber();
        gameService.createPurchaseAmount(purchaseAmount);
        gameService.createWinningLotto(winningNumber, bonusNumber);
    }
}
