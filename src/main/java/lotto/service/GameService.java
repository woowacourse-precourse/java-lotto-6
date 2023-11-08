package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.LotteryOffice;
import lotto.domain.LottoStore;
import lotto.domain.Rankings;
import lotto.domain.WinningNumbers;
import lotto.domain.YieldCalculator;
import lotto.domain.lotto.Lotto;

public class GameService {

    private final List<Lotto> issuedLotto;
    private final int userPurchaseAmount;
    private LotteryOffice lotteryOffice;

    private GameService(List<Lotto> issuedLotto, int userPurchaseAmount) {
        this.issuedLotto = issuedLotto;
        this.userPurchaseAmount = userPurchaseAmount;
    }

    public static GameService setUpGame(int userPurchaseAmount) {
        LottoStore lottoStore = new LottoStore(userPurchaseAmount);
        while (lottoStore.isOpen()) {
            lottoStore.issueLotto();
        }
        return new GameService(lottoStore.getIssuedLotto(), userPurchaseAmount);
    }

    public void storeUserInput(WinningNumbers winningNumbers) {
        this.lotteryOffice = new LotteryOffice(issuedLotto, winningNumbers);
    }

    public Map<Rankings, Integer> getStatistics() {
        return lotteryOffice.getWinningsAndCounts();
    }

    public String getCalculatedYield() {
        YieldCalculator yieldCalculator = new YieldCalculator(
                lotteryOffice.getWinningsAndCounts(), userPurchaseAmount);
        return yieldCalculator.getYield();
    }

    public List<Lotto> getIssuedLotto() {
        return issuedLotto;
    }

}

