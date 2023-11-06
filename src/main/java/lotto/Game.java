package lotto;

import static lotto.InputReader.*;
import static lotto.MessagePrinter.*;
import static lotto.Util.*;

import java.util.List;

public class Game {
    public void run() {
        askPurchaseAmount();
        int purchaseAmount = inputPurchaseAmount();
        int purchaseCount = getLottoCount(purchaseAmount);

        UserLotto userLotto = new UserLotto(purchaseCount);
        List<Lotto> userLottoNumbers = userLotto.getUserLottos();
        printCompletePurchase(purchaseCount, userLottoNumbers);

        askWinningLotto();
        Lotto lotto = inputWinningLotto();

        askBonusNumber();
        int bonusNumber = inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
    }
}
