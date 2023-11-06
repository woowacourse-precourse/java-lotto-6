package lotto.dto;

import static lotto.constants.Message.NEW_LINE;

import java.util.Map;
import java.util.TreeMap;
import lotto.constants.WinningType;

public record WinningResult(Map<WinningType, Integer> winningMap) {
    public WinningResult() {
        this(new TreeMap<>(Map.of(
                WinningType.NONE, 0,
                WinningType.THREE, 0,
                WinningType.FOUR, 0,
                WinningType.FIVE, 0,
                WinningType.FIVE_BONUS, 0,
                WinningType.SIX, 0
        )));
    }

    public void updateResult(int matchedCount, boolean isBonus) {
        WinningType winningType = WinningType.findTypeByCount(matchedCount, isBonus);
        winningMap.replace(winningType, winningMap.get(winningType) + 1);
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
        winningMap.keySet()
                .forEach((winningType) -> {
                    String message = winningType.getMessage();
                    int quantity = winningMap.get(winningType);
                    builder.append(String.format(message + NEW_LINE.getMessage(), quantity));
                });
        return builder.toString();
    }
}

