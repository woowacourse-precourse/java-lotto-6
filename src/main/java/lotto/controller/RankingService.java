package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Ranking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingService {
    private Map<Ranking, Integer> rankingCounts = new HashMap<>();

    public List<Ranking> calculateRankingResults(List<Lotto> lottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        List<Ranking> rankingResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            rankingResults.add(lotto.checkRanking(winningNumbers, bonusNumber));
        }
        return rankingResults;
    }

    private void makeRankingCountsDefault() {
        for (Ranking ranking: Ranking.values()) {
            rankingCounts.put(ranking, 0);
        }
    }

    public Map<Ranking, Integer> countRanking(List<Ranking> rankingResults) {
        makeRankingCountsDefault();
        for (Ranking ranking : rankingResults) {
            int currentCount = rankingCounts.get(ranking);
            rankingCounts.put(ranking, currentCount + 1);
        }
        return rankingCounts;
    }
}
