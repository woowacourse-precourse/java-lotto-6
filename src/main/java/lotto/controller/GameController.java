package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;
import lotto.handler.InputHandler;
import lotto.service.LottoService;
import lotto.utils.InputSupplier;
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
        int lottoQuantity = getInput(() -> getLottoQuantity());
        List<Lotto> lottos = lottoService.buyLottos(lottoQuantity);
        gameView.showLottos(lottos);

        List<Integer> winningNumbers = getInput(() -> getWinningNumbers());
        int bonusNumber = getInput(() -> getBonusNumber((winningNumbers)));

        WinningStatistics winningStatistics = lottoService.getWinningStatistics(lottos, winningNumbers, bonusNumber);
        gameView.showWinningStatistics(winningStatistics);
    }

    private <T> T getInput(InputSupplier<T> inputSupplier) {
        while (true) try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            gameView.showError(e.getMessage());
        }
    }

    private int getLottoQuantity() throws IllegalArgumentException {
        String purchaseAmountInput = gameView.getPurchaseAmountInput();
        return inputHandler.handlePurchaseAmount(purchaseAmountInput);
    }

    private List<Integer> getWinningNumbers() throws IllegalArgumentException {
        String winningNumbersInput = gameView.getWinningNumbersInput();
        return inputHandler.handleWinningNumbers(winningNumbersInput);
    }

    private int getBonusNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        String bonusNumberInput = gameView.getBonusNumberInput();
        return inputHandler.handleBonusBall(bonusNumberInput, winningNumbers);
    }
}
