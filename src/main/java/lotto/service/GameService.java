package lotto.service;

import lotto.domain.Lotteries;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.util.RandomNumberGenerator;

public class GameService {

    private final RandomNumberGenerator randomNumberGenerator;

    private PurchaseAmount purchaseAmount;
    private WinningLotto winningLotto;
    private Lotteries lotteries;

    public GameService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void createPurchaseAmount(String userInput) {
        purchaseAmount = PurchaseAmount.from(userInput);
    }

    public void createWinningLotto(String winningNumber, String bonusNumber) {
        winningLotto = WinningLotto.of(winningNumber, bonusNumber);
    }

    public void createLotteries() {
        lotteries = Lotteries.from(purchaseAmount.calculateNumberOfLotteries());
    }
}
