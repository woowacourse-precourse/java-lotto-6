package lotto.controller;

import lotto.domain.Lotto;
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
        try {
            String purchaseAmount = inputView.inputPurchaseAmount();
            gameService.createPurchaseAmount(purchaseAmount);
            gameService.createLotteries();
            outputView.printPurchaseAmount(gameService.printPurchaseAmount());
            outputView.printLottoNumbers(gameService.printLottoNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startGame();
        }
    }

    private void playGame() {
        try {
            String winningNumber = inputView.inputWinningNumber();
            String bonusNumber = inputView.inputBonusNumber();
            gameService.createWinningLotto(winningNumber, bonusNumber);
            gameService.createLottoResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            playGame();
        }
    }

    private void stopGame() {
        outputView.printGameResult(gameService.printGameResult());
        outputView.printEarningRate(gameService.printEarningRate());
    }
}
