package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public void run() {
        int purchaseAmount = buyLotto();
        UserLotto userLotto = completeBuyingLotto(purchaseAmount);
        WinningLotto winningLotto = createWinningLotto();
        winningResult(purchaseAmount, userLotto, winningLotto);
    }

    private static int buyLotto() {
        try {
            OutputView.askPurchaseAmount();
            return InputView.inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return buyLotto();
        }
    }

    private static UserLotto completeBuyingLotto(int purchaseAmount) {
        UserLotto userLotto = new UserLotto(purchaseAmount);
        List<Lotto> userLottoNumbers = userLotto.getUserLottos();
        OutputView.printCompletePurchase(purchaseAmount, userLottoNumbers);
        return userLotto;
    }

    private static WinningLotto createWinningLotto() {
        try {
            Lotto lotto = getWinningLotto();
            int bonusNumber = getBonusNumber();
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createWinningLotto();
        }
    }

    private static Lotto getWinningLotto() {
        try {
            OutputView.askWinningLotto();
            return InputView.inputWinningLotto();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningLotto();
        }
    }

    private static int getBonusNumber() {
        try {
            OutputView.askBonusNumber();
            return InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getBonusNumber();
        }
    }

    private static void winningResult(int purchaseAmount, UserLotto userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> rankResult = userLotto.checkWinning(winningLotto);
        OutputView.printWinningStatistics(rankResult);
        float rateOfReturn = userLotto.getRateOfReturn(purchaseAmount);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
