package lotto.domain.strategy;

import lotto.domain.WinningStatistics;

import java.util.Map;

public class FiveBonusMatchedWinningStrategy implements WinningStrategy{
    @Override
    public void apply(Map<WinningStatistics, Integer> totalStatistics) {
        int fiveBonusCount = totalStatistics.get(WinningStatistics.FIVE_BONUS_MATCH);
        totalStatistics.put(WinningStatistics.FIVE_BONUS_MATCH, fiveBonusCount+1);
    }

}
