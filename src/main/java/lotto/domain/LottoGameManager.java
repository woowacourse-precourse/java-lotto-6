package lotto.domain;

import lotto.domain.exception.UserInputValidator;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

public class LottoGameManager {
    public void start() {
        Lottos lottos = new Lottos(saveLottos());
        OutputView.showLottos(lottos);

        WinningLotto winningLotto = new WinningLotto();
        winningLotto.createLotto(saveLotto());
        winningLotto.createBonusNumber(saveBonusNumber(winningLotto.getLotto()));

        /**
         * 당첨 통계 기능 구현 필요
         */
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
