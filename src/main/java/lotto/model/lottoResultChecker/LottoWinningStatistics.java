package lotto.model.lottoResultChecker;

import java.util.List;
import java.util.Map;

public class LottoWinningStatistics {

    private final LottoRankChecker rankChecker;

    public LottoWinningStatistics() {
        this.rankChecker = new LottoRankChecker();
    }

    public Map<LottoRank, Integer> calculateStatistics(List<Lotto> lottos, Lotto winningLotto, LottoBonus bonus) {
        LottoMatchingData matchingData = new LottoMatchingData();

        for (Lotto lotto : lottos) {
            LottoRank rank = rankChecker.determineRank(lotto, winningLotto, bonus);
            matchingData.addMatch(rank);
        }

        return matchingData.getRankCount();
    }
}
