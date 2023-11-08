package lotto.Service;

import lotto.domain.Lotto;

import java.util.List;

public class StatisticsService {

    private final StatisticsUtil statisticsUtil = new StatisticsUtil();

    // 각 등수가 나온 빈도수 반환
    // ex) [12, 8, 3, 5, 4, 2, 0, 1]
    // -> 1등: 1개, 2등: 0개, 3등: 2개, 4등: 4개, ... 0개 일치: 12개
    public List<Integer> winningStats(List<Lotto> lottos, List<Integer> winningNum, Integer bonusNum) {
        List<Integer> matchCount = statisticsUtil.getMatchCount(lottos, winningNum, bonusNum);
        return statisticsUtil.matchCountFrequency(matchCount);
    }

    // 수익률 반환
    // ex) 550.0%
    public float returnRate(List<Integer> matchFrequency, List<String> reward) {
        Integer totalReward = statisticsUtil.getTotalReward(matchFrequency, reward);
        return statisticsUtil.getReturnRate(matchFrequency, (float) totalReward);
    }
}
