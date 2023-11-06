package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.constants.WinningCriteria;

public class WinningStatistics {

    private final Map<WinningCriteria, Integer> winningInfo;

    public WinningStatistics() {
        winningInfo = new EnumMap(WinningCriteria.class);
        initializeWinningInfo();
    }

    private void initializeWinningInfo() {
        Arrays.stream(WinningCriteria.values())
                .forEach(criteria -> winningInfo.put(criteria, 0));
    }

    public void addResult(WinningCriteria winningCriteria) {
        winningInfo.put(winningCriteria, winningInfo.get(winningCriteria) + 1);
    }

    public int calculateTotalPrizeAmount() {
        return Arrays.stream(WinningCriteria.values())
                .mapToInt(criteria -> criteria.getPrizeAmount() * winningInfo.get(criteria))
                .sum();
    }

    public Map<WinningCriteria, Integer> getWinningInfo() {
        return winningInfo;
    }
}
