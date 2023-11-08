package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Prize, Integer> result = new EnumMap<>(Prize.class);
    private final int purchaseAmount;

    public WinningResult(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void incrementPrizeCount(Prize prize) {
        result.put(prize, result.getOrDefault(prize, 0) + 1);
    }

    public int searchWinningCountForPrize(Prize prize) {
        return result.getOrDefault(prize, 0);
    }

    public double getEarningRate() {
        int totalPrize = 0;
        for (Prize prize : Prize.values()) {
            totalPrize += prize.getPrizeMoney() * searchWinningCountForPrize(prize);
        }
        return ((double) totalPrize / (double) purchaseAmount) * 100;
    }
}
