package lotto;

import static lotto.InputReader.*;
import static lotto.MessagePrinter.*;
import static lotto.Util.*;

import java.util.List;
import java.util.Map;

public class Game {
    public void run() {
        int purchaseAmount = buyLotto();
        UserLotto userLotto = completeBuyingLotto(purchaseAmount);
        WinningLotto winningLotto = createWinningLotto();
        winningResult(purchaseAmount, userLotto, winningLotto);
    }

    private static int buyLotto() {
        try {
            askPurchaseAmount();
            return inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return buyLotto();
        }
    }

    private static UserLotto completeBuyingLotto(int purchaseAmount) {
        UserLotto userLotto = new UserLotto(purchaseAmount);
        List<Lotto> userLottoNumbers = userLotto.getUserLottos();
        printCompletePurchase(purchaseAmount, userLottoNumbers);
        return userLotto;
    }

    private static WinningLotto createWinningLotto() {
        try {
            Lotto lotto = getWinningLotto();
            int bonusNumber = getBonusNumber();
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return createWinningLotto();
        }
    }

    private static Lotto getWinningLotto() {
        try {
            askWinningLotto();
            return inputWinningLotto();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getWinningLotto();
        }
    }

    private static int getBonusNumber() {
        try {
            askBonusNumber();
            return inputBonusNumber();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getBonusNumber();
        }
    }

    private static void winningResult(int purchaseAmount, UserLotto userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> rankResult = userLotto.checkWinning(winningLotto);
        printWinningStatistics(rankResult);
        float rateOfReturn = userLotto.getRateOfReturn(purchaseAmount);
        printRateOfReturn(rateOfReturn);
    }
}
