package lotto.service;

import lotto.domain.Comparator;
import lotto.domain.Lotto;
import lotto.constants.LottoRankConstants;
import lotto.domain.LottoRanks;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoDrawService {
    LottoRanks lottoRanks = new LottoRanks();

    public LottoRanks evaluateRanks(WinningLotto winningLotto, List<Lotto> purchasedLottos) {
        Comparator comparator = new Comparator(winningLotto);
        for (Lotto purchasedLotto : purchasedLottos) {
            LottoRankConstants rank = comparator.compareWithWinningLotto(purchasedLotto);
            storeRank(rank);
        }
        return lottoRanks;
    }

    public int getWinningAmount() {
        int totalAmount = 0;
        for (LottoRankConstants rank : LottoRankConstants.values()) {
            totalAmount += lottoRanks.getRankCount(rank) * rank.getPrizeAmount();
        }
        return totalAmount;
    }

    private void storeRank(LottoRankConstants lottoRank) {
        this.lottoRanks = lottoRanks.recordRank(lottoRank);
    }
}
