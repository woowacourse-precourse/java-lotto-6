package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;
import lotto.handler.InputHandler;
import lotto.utils.InputSupplier;
import lotto.view.GameInputView;

import java.util.List;

public class GameService {
    private final GameInputView gameInputView;
    private final InputHandler inputHandler;
    private final LottoService lottoService;

    public GameService(GameInputView gameInputView, InputHandler inputHandler, LottoService lottoService) {
        this.gameInputView = gameInputView;
        this.inputHandler = inputHandler;
        this.lottoService = lottoService;
    }

    public List<Lotto> getLottos() {
        Integer lottoQuantity = getInput(() -> getLottoQuantity());
        return lottoService.buyLottos(lottoQuantity);
    }

    public List<Integer> getWinningNumbers() {
        return getInput(() -> getWinningNumbersInput());
    }

    public int getBonusBall(List<Integer> winningNumbers) {
        return getInput(() -> getBonusBallInput(winningNumbers));
    }

    public WinningStatistics getWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusBall) {
        return lottoService.getWinningStatistics(lottos, winningNumbers, bonusBall);
    }

    private <T> T getInput(InputSupplier<T> inputSupplier) {
        while (true) try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            gameInputView.showError(e.getMessage());
        }
    }

    private int getLottoQuantity() throws IllegalArgumentException {
        String purchaseAmountInput = gameInputView.getPurchaseAmountInput();
        return inputHandler.handlePurchaseAmount(purchaseAmountInput);
    }

    private List<Integer> getWinningNumbersInput() throws IllegalArgumentException {
        String winningNumbersInput = gameInputView.getWinningNumbersInput();
        return inputHandler.handleWinningNumbers(winningNumbersInput);
    }

    private int getBonusBallInput(List<Integer> winningNumbers) throws IllegalArgumentException {
        String bonusNumberInput = gameInputView.getBonusNumberInput();
        return inputHandler.handleBonusBall(bonusNumberInput, winningNumbers);
    }
}
