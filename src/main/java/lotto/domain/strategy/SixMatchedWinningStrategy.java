package lotto.domain.strategy;

import lotto.domain.WinningStatistics;

import java.util.Map;

public class SixMatchedWinningStrategy implements WinningStrategy{
    @Override
    public void apply(Map<WinningStatistics, Integer> totalStatistics) {
        int sixCount = totalStatistics.get(WinningStatistics.SIX_MATCH);
        totalStatistics.put(WinningStatistics.SIX_MATCH, sixCount+1);
    }

}
