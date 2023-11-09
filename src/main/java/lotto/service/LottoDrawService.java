package lotto.service;

import static lotto.constants.LottoConstants.INCREASING_UNIT;

import lotto.constants.RankConstants;
import lotto.domain.LottoRankEvaluator;
import lotto.domain.LottoRanks;
import lotto.dto.Lotto;
import lotto.dto.Lottos;
import lotto.dto.WinningLotto;

public class LottoDrawService {
    LottoRanks lottoRanks = new LottoRanks();

    public LottoRanks evaluateRanks(WinningLotto winningLotto, Lottos purchasedLottos) {
        LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);
        for (Lotto purchasedLotto : purchasedLottos.lottos()) {
            RankConstants rank = lottoRankEvaluator.compareWithWinningLotto(purchasedLotto);
            lottoRanks.recordRank(rank);
        }
        return lottoRanks;
    }

    public int getWinningAmount() {
        int totalAmount = INCREASING_UNIT;
        for (RankConstants rank : RankConstants.values()) {
            totalAmount += lottoRanks.getRankCount(rank) * rank.getPrizeAmount();
        }
        return totalAmount;
    }
}
