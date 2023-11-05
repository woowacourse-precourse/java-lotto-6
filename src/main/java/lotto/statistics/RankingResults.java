package lotto.statistics;

import java.util.List;
import lotto.bonus.BonusNumber;
import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import lotto.ranking.Ranking;

public class RankingResults {

    private final List<Ranking> rankings;

    private RankingResults(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    public static RankingResults of(List<Lotto> lottos, WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<Ranking> rankingResults = aggregateRankingResult(lottos, winningLotto, bonusNumber);
        return new RankingResults(rankingResults);
    }

    private static List<Ranking> aggregateRankingResult(List<Lotto> lottos,
                                                        WinningLotto winningLotto,
                                                        BonusNumber bonusNumber) {
        return lottos.stream().map(lotto -> calculateRanking(lotto, winningLotto, bonusNumber)).toList();
    }

    private static Ranking calculateRanking(Lotto lotto, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return Ranking.calculateRanking(winningLotto.getMatchNumberCount(lotto), lotto.hasBonusNumber(bonusNumber));
    }

    public List<Ranking> getRankings() {
        return rankings;
    }
}
