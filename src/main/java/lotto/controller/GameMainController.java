package lotto.controller;

import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMainController {

    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMainController(GameService gameService, InputView inputView, OutputView outputView) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        startGame();
        playGame();
        stopGame();
    }

    private void startGame() {
        String purchaseAmount = inputView.inputPurchaseAmount();
        String winningNumber = inputView.inputWinningNumber();
        String bonusNumber = inputView.inputBonusNumber();
        gameService.createPurchaseAmount(purchaseAmount);
        gameService.createWinningLotto(winningNumber, bonusNumber);
        outputView.printPurchaseAmount(purchaseAmount);
    }

    private void playGame() {

    }

    private void stopGame() {

    }
}
