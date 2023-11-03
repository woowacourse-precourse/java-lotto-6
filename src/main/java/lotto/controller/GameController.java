package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;
import lotto.handler.InputHandler;
import lotto.service.LottoService;
import lotto.view.GameView;

import java.util.List;

public class GameController {
    private final GameView gameView;
    private final InputHandler inputHandler;
    private final LottoService lottoService;

    public GameController(GameView gameView, InputHandler inputHandler, LottoService lottoService) {
        this.gameView = gameView;
        this.inputHandler = inputHandler;
        this.lottoService = lottoService;
    }

    public void startGame() {
        int lottoQuantity = getLottoQuantity();

        List<Lotto> lottos = lottoService.buyLottos(lottoQuantity);
        gameView.showLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        WinningStatistics winningStatistics = lottoService.getWinningStatistics(lottos, winningNumbers, bonusNumber);
        gameView.showWinningStatistics(winningStatistics);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberInput = gameView.getBonusNumberInput();
        return inputHandler.handleBonusNumber(bonusNumberInput, winningNumbers);
    }

    private List<Integer> getWinningNumbers() {
        String winningNumbersInput = gameView.getWinningNumbersInput();
        return inputHandler.handleWinningNumbers(winningNumbersInput);
    }

    private int getLottoQuantity() {
        String purchaseAmountInput = gameView.getPurchaseAmountInput();
        return inputHandler.handlePurchaseAmount(purchaseAmountInput);
    }
}
