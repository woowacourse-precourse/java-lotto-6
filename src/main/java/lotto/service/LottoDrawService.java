package lotto.service;

import lotto.constants.LottoRankConstants;
import lotto.dto.Lotto;
import lotto.dto.Lottos;
import lotto.dto.WinningLotto;
import lotto.repository.LottoRanks;

public class LottoDrawService {
    LottoRanks lottoRanks = new LottoRanks();

    public LottoRanks evaluateRanks(WinningLotto winningLotto, Lottos purchasedLottos) {
        Comparator comparator = new Comparator(winningLotto);
        for (Lotto purchasedLotto : purchasedLottos.lottos()) {
            LottoRankConstants rank = comparator.compareWithWinningLotto(purchasedLotto);
            lottoRanks.recordRank(rank);
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
}
