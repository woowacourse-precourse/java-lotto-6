package lotto.domain;

import static lotto.constants.Message.NEW_LINE;

import java.util.Map;
import java.util.TreeMap;
import lotto.constants.WinningType;

public class WinningResult {
    private final Map<WinningType, Integer> winningMap;

    public WinningResult() {
        winningMap = new TreeMap<>(Map.of(
                WinningType.NONE, 0,
                WinningType.THREE, 0,
                WinningType.FOUR, 0,
                WinningType.FIVE, 0,
                WinningType.FIVE_BONUS, 0,
                WinningType.SIX, 0
        ));
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


    // TODO: toString으로 문자열을 직접 만들어서 보내는 것은 적절하지 않은 것 같다! 데이터만 넘기는 방법을 사용하자
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

