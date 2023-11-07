package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStats;
import lotto.exception.UserInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameManager {
    public void start() {
        Lottos lottos = new Lottos(getValidatedLottos());
        OutputView.showLottos(lottos);

        WinningLotto winningLotto = new WinningLotto();
        winningLotto.createLotto(getValidatedLotto());
        winningLotto.createBonusNumber(getValidatedBonusNumber(winningLotto.getLotto()));

        WinningStats winningStats = WinningStats.createWinningStats(lottos.getPurchasePrice(), lottos, winningLotto);
        showWinningStats(winningStats);
    }

    private static void showWinningStats(WinningStats winningStats) {
        OutputView.showWinningStatsIntroduction();
        OutputView.showWinningStatsResult(winningStats);
        OutputView.showRateOfReturn(winningStats);
    }

    public int getValidatedLottos() {
        while (true) {
            try {
                String purchasePrice = InputView.readPurchasePrice();
                UserInputValidator.validatePurchasePrice(purchasePrice);
                return Integer.parseInt(purchasePrice);
            } catch (IllegalArgumentException e) {
                OutputView.showErrorMessage(e.getMessage());
            }
        }
    }

    public String getValidatedLotto() {
        while (true) {
            try {
                String winningNumber = InputView.readWinningNumber();
                UserInputValidator.validateWinningLotto(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                OutputView.showErrorMessage(e.getMessage());
            }
        }
    }

    public String getValidatedBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String bonusNumber = InputView.readBonusNumber();
                UserInputValidator.validateBonusNumber(winningLotto, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                OutputView.showErrorMessage(e.getMessage());
            }
        }
    }
}