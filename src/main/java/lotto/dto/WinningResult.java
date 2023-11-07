package lotto.dto;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import lotto.constants.WinningType;

public class WinningResult {
    private final Map<WinningType, Integer> winningMap;
    private int totalPrize;

    public WinningResult() {
        winningMap = new TreeMap<>(Map.of(
                WinningType.NONE, 0,
                WinningType.THREE, 0,
                WinningType.FOUR, 0,
                WinningType.FIVE, 0,
                WinningType.FIVE_BONUS, 0,
                WinningType.SIX, 0
        ));
        totalPrize = 0;
    }

    public void updateResult(int matchedCount, boolean isBonus) {
        WinningType winningType = WinningType.findTypeByCount(matchedCount, isBonus);
        winningMap.replace(winningType, winningMap.get(winningType) + 1);
    }

    public int getTotalPrize() {
        for (WinningType winningType : winningMap.keySet()) {
            int amount = winningMap.get(winningType);
            totalPrize += winningType.calculateProfit(amount);
        }
        return totalPrize;
    }

    public Map<WinningType, Integer> getWinningMap() {
        return Collections.unmodifiableMap(this.winningMap);
    }
}

