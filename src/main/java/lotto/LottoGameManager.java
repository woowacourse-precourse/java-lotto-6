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
        Lottos lottos = new Lottos(saveLottos());
        OutputView.showLottos(lottos);

        WinningLotto winningLotto = new WinningLotto();
        winningLotto.createLotto(saveLotto());
        winningLotto.createBonusNumber(saveBonusNumber(winningLotto.getLotto()));

        WinningStats winningStats = WinningStats.createWinningStats(lottos.getPurchasePrice(), lottos, winningLotto);
        OutputView.showWinningStatsIntroduction();
        OutputView.showWinningStatsResult(winningStats);
        OutputView.showRateOfReturn(winningStats);
    }

    public int saveLottos() {
        try {
            String purchasePrice = InputView.readPurchasePrice();
            UserInputValidator.validatePurchasePrice(purchasePrice);
            return Integer.parseInt(purchasePrice);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return saveLottos();
        }
    }

    public String saveLotto() {
        try {
            String winningNumber = InputView.readWinningNumber();
            UserInputValidator.validateWinningLotto(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return saveLotto();
        }
    }

    public String saveBonusNumber(Lotto winningLotto) {
        try {
            String bonusNumber = InputView.readBonusNumber();
            UserInputValidator.validateBonusNumber(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return saveBonusNumber(winningLotto);
        }
    }
}
