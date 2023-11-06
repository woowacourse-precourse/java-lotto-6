package lotto.Service;

import lotto.domain.Lotto;

import java.util.List;

public class StatisticsService {

    private final StatisticsUtil statisticsUtil = new StatisticsUtil();

    public List<Integer> winningStats(List<Lotto> lottos, List<Integer> winningNum, Integer bonusNum) {
        List<Integer> matchCount = statisticsUtil.getMatchCount(lottos, winningNum, bonusNum);
        return statisticsUtil.matchCountFrequency(matchCount);
    }

    public float returnRate(List<Integer> matchFrequency, List<String> reward) {
        Integer totalReward = statisticsUtil.getTotalReward(matchFrequency, reward);
        return statisticsUtil.getReturnRate(matchFrequency, (float) totalReward);
    }
}
