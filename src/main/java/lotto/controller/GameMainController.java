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
        gameService.createPurchaseAmount(purchaseAmount);
        gameService.createLotteries();
        outputView.printPurchaseAmount(purchaseAmount);
        outputView.printLottoNumbers(gameService.printLottoNumbers());
    }

    private void playGame() {
        String winningNumber = inputView.inputWinningNumber();
        String bonusNumber = inputView.inputBonusNumber();
        gameService.createWinningLotto(winningNumber, bonusNumber);
    }

    private void stopGame() {

    }
}
