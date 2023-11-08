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
            setLotteries();
            setWinningNumber();
            setWinningLotto();
            playGame();
            stopGame();
    }

    private void setLotteries() {
        try {
            String purchaseAmount = inputView.inputPurchaseAmount();
            gameService.createPurchaseAmount(purchaseAmount);
            gameService.createLotteries();
            outputView.printPurchaseAmount(gameService.printPurchaseAmount());
            outputView.printLottoNumbers(gameService.printLottoNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setLotteries();
        }
    }

    private void setWinningNumber() {
        try {
            String winningNumber = inputView.inputWinningNumber();
            gameService.createWinningNumbers(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningNumber();
        }
    }

    private void setWinningLotto() {
        try {
            String bonusNumber = inputView.inputBonusNumber();
            gameService.createWinningLotto(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningLotto();
        }
    }

    private void playGame() {
        gameService.createLottoResult();
    }

    private void stopGame() {
        outputView.printGameResult(gameService.printGameResult());
        outputView.printEarningRate(gameService.printEarningRate());
    }
}
