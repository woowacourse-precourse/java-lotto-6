package lotto.domain.strategy;

import lotto.domain.WinningStatistics;

import java.util.Map;

public class FourMatchedWinningStrategy implements WinningStrategy{
    @Override
    public void apply(Map<WinningStatistics, Integer> totalStatistics) {
        int fourCount = totalStatistics.get(WinningStatistics.FOUR_MATCH);
        totalStatistics.put(WinningStatistics.FOUR_MATCH, fourCount+1);
    }

}
