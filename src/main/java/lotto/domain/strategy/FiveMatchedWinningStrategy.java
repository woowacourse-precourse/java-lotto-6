package lotto.domain.strategy;

import lotto.domain.WinningStatistics;

import java.util.Map;

public class FiveMatchedWinningStrategy implements WinningStrategy{
    @Override
    public void apply(Map<WinningStatistics, Integer> totalStatistics) {
        int fiveCount = totalStatistics.get(WinningStatistics.FIVE_MATCH);
        totalStatistics.put(WinningStatistics.FIVE_MATCH, fiveCount+1);
    }

}
