package lotto.domain.strategy;

import lotto.domain.WinningStatistics;

import java.util.Map;

public class ThreeMatchedWinningStrategy implements WinningStrategy{
    @Override
    public void apply(Map<WinningStatistics, Integer> totalStatistics) {
        int threeCount = totalStatistics.get(WinningStatistics.THREE_MATCH);
        totalStatistics.put(WinningStatistics.THREE_MATCH, threeCount+1);
    }

}
