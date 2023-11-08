package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.RankingCounter;
import lotto.domain.WinningLotto;
import lotto.dto.ComparatorRequest;

public class LottoCalculator {

    private static final int HUNDRED_PERCENT = 100;
    private static final double HUNDRED_PERCENT_DOUBLE = 100.0;

    private final RankingCounter rankingCounter;

    public LottoCalculator(RankingCounter rankingCounter) {
        this.rankingCounter = rankingCounter;
    }

    public void compareLotto(ComparatorRequest comparatorRequest) {
        WinningLotto winningLotto = comparatorRequest.winningLotto();
        List<Lotto> playerLotto = comparatorRequest.playerNumbers();
        for (Lotto lotto : playerLotto) {
            int rank = lotto.compareToPlayerLotto(winningLotto);
            if (winningLotto.hasBonusNumber(rank, lotto)) {
                rankingCounter.changeCountWhenHasBonusNumber();
            }
            rankingCounter.increaseRankingCount(rank);
        }
    }

    public double calculatePayOff(int purchaseMoney) {
        double payOff = ((double) Ranking.getTotalPrizeMoney(rankingCounter) / purchaseMoney) * HUNDRED_PERCENT;
        return  Math.round(payOff * HUNDRED_PERCENT) / HUNDRED_PERCENT_DOUBLE;
    }
}
