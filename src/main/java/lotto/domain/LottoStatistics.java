package lotto.domain;

import lotto.constants.WinningFactor;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private static final Integer MATCH_UP = 1;
    private static final Integer INIT_VALUE = 0;
    private final EnumMap<WinningFactor, Integer> statistics = new EnumMap<>(WinningFactor.class);

    public LottoStatistics() {
        for (WinningFactor factor : WinningFactor.values()) {
            statistics.put(factor, INIT_VALUE);
        }
    }

    public void upWinningFactorValue(Integer matchCount, Boolean isMatchBonusNumber) {
        WinningFactor winningFactorByCount = WinningFactor.findWinningFactorByCount(matchCount, isMatchBonusNumber);
        statistics.put(winningFactorByCount, statistics.get(winningFactorByCount) + MATCH_UP);
    }

    public Map<WinningFactor, Integer> getStatistics() {
        return new EnumMap<>(statistics);
    }

    public Integer calculateWinningPrice() {
        int winningSum = INIT_VALUE;
        for (Map.Entry<WinningFactor, Integer> entry : statistics.entrySet()) {
            WinningFactor winningFactor = entry.getKey();
            Integer value = entry.getValue();
            winningSum += winningFactor.getMoney() * value;
        }
        return winningSum;
    }
}
