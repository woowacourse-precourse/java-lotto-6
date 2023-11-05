package lotto.service;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.util.NumberGenerator;
import lotto.util.RandomNumberGenerator;

public class GameService {

    private final NumberGenerator numberGenerator;

    private PurchaseAmount purchaseAmount;
    private WinningLotto winningLotto;
    private Lotteries lotteries;

    public GameService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void createPurchaseAmount(String userInput) {
        purchaseAmount = PurchaseAmount.from(userInput);
    }

    public void createWinningLotto(String winningNumber, String bonusNumber) {
        winningLotto = WinningLotto.of(winningNumber, bonusNumber);
    }
}
