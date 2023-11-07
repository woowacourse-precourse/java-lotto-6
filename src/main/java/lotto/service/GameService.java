package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LotteryOffice;
import lotto.domain.LottoStore;
import lotto.domain.MarginCalculator;
import lotto.domain.Rankings;
import lotto.domain.lotto.Lotto;

public class GameService {
    private final List<Lotto> issuedLotto;
    private LotteryOffice lotteryOffice;
    private final int userPurchaseAmount;
    public GameService(List<Lotto> issuedLotto, int userPurchaseAmount) {
        this.issuedLotto = issuedLotto;
        this.userPurchaseAmount = userPurchaseAmount;
    }

    public static GameService startGame(int userPurchaseAmount) {
        LottoStore lottoStore = new LottoStore(userPurchaseAmount);
        while (lottoStore.isOpen()) {
            lottoStore.issueLotto();
        }
        return new GameService(lottoStore.getIssuedLotto(), userPurchaseAmount);
    }

    public void storeUserInput(Lotto winningTicket, BonusNumber bonusNumber) {
        this.lotteryOffice = new LotteryOffice(issuedLotto, winningTicket, bonusNumber);
    }

    public Map<Rankings, Integer> getStatistics() {
        return lotteryOffice.getWinningsAndCounts();
    }

    public String getCalculatedMargin() {
        MarginCalculator marginCalculator = new MarginCalculator(
                lotteryOffice.getWinningsAndCounts(), userPurchaseAmount);
        return marginCalculator.getMargin();
    }


    public List<Lotto> getIssuedLotto() {
        return issuedLotto;
    }

}

