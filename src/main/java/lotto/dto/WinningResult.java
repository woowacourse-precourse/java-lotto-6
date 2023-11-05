package lotto.dto;

import static lotto.constants.Message.NEW_LINE;

import java.util.Map;
import java.util.TreeMap;
import lotto.constants.WinningType;

public record WinningResult(Map<WinningType, Integer> winningMap) {
    public WinningResult() {
        this(new TreeMap<>(Map.of(
                WinningType.THREE, 0,
                WinningType.FOUR, 0,
                WinningType.FIVE, 0,
                WinningType.FIVE_BONUS, 0,
                WinningType.SIX, 0
        )));
    }

    public void updateResult(int matchedCount, boolean isBonus) {
        if (matchedCount == 3) {
            winningMap.replace(WinningType.THREE, winningMap().get(WinningType.THREE) + 1);
        } else if (matchedCount == 4) {
            winningMap.replace(WinningType.FOUR, winningMap().get(WinningType.FOUR) + 1);
        } else if (matchedCount == 5) {
            if (isBonus) {
                winningMap.replace(WinningType.FIVE_BONUS, winningMap().get(WinningType.FIVE_BONUS) + 1);
                return;
            }
            winningMap.replace(WinningType.FIVE, winningMap().get(WinningType.FIVE) + 1);
        } else if (matchedCount == 6) {
            winningMap.replace(WinningType.SIX, winningMap().get(WinningType.SIX) + 1);
        }
    }

    public int getTotalPrize() {
        int totalPrize = 0;

        for (WinningType winningType : winningMap.keySet()) {
            int amount = winningMap.get(winningType);
            totalPrize += winningType.calculateProfit(amount);
        }
        return totalPrize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<WinningType, Integer> entry : winningMap.entrySet()) {
            builder.append(String.format(entry.getKey().getMessage() + NEW_LINE.getMessage(), entry.getValue()));
        }
        return builder.toString();
    }
}

