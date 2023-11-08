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
        askPurchaseAmount();
        return inputPurchaseAmount();
    }

    private static UserLotto completeBuyingLotto(int purchaseAmount) {
        UserLotto userLotto = new UserLotto(purchaseAmount);
        List<Lotto> userLottoNumbers = userLotto.getUserLottos();
        printCompletePurchase(purchaseAmount, userLottoNumbers);
        return userLotto;
    }

    private static WinningLotto createWinningLotto() {
        try {
            askWinningLotto();
            Lotto lotto = inputWinningLotto();
            askBonusNumber();
            int bonusNumber = inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
            return winningLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLotto();
        }
    }

    private static void winningResult(int purchaseAmount, UserLotto userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> rankResult = userLotto.checkWinning(winningLotto);
        printWinningStatistics(rankResult);
        float rateOfReturn = userLotto.getRateOfReturn(purchaseAmount);
        printRateOfReturn(rateOfReturn);
    }
}
