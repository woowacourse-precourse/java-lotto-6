package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoDrawMachine {
    private final PurchaseRepository purchaseRepository = PurchaseRepository.getInstance();
    private final LottoRanks lottoRanks = LottoRanks.getInstance();
    private WinningLotto winningLotto;

    public LottoDrawMachine(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    private List<Lotto> getPurchasedAllLotto() {
        return purchaseRepository.findLottos();
    }

    public void evaluateRanks(List<Lotto> purchasedLottos) {
        Comparator comparator = new Comparator(winningLotto);
        for (Lotto purchasedLotto : purchasedLottos) {
            storeRank(comparator.compareWithWinningLotto(purchasedLotto));
        }
    }

    public int getWinningAmount() {
        int totalAmount = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalAmount += lottoRanks.getRankCount(rank) * rank.getPrizeAmount();
        }
        return totalAmount;
    }

    private void storeRank(LottoRank lottoRank) {
        lottoRanks.increaseRankCount(lottoRank);
    }

}
