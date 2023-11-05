package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class GameService {

    private PurchaseAmount purchaseAmount;
    private WinningLotto winningLotto;

    public void createPurchaseAmount(String userInput) {
        purchaseAmount = PurchaseAmount.from(userInput);
    }

    public void createWinningLotto(String winningNumber, String bonusNumber) {
        winningLotto = WinningLotto.of(winningNumber, bonusNumber);
    }
}
