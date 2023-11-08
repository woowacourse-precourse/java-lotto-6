package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.constants.RankMessage;

public class Calculation {
    private static final int PERCENTAGE = 100;
    private static final double NUMBER_FOR_ROUND = 10.0;

    public static double calculateProfitRate(long totalPrizeMoney, int purchaseAmount) {
        double profitRatePercent = ((double) totalPrizeMoney / purchaseAmount) * PERCENTAGE;
        return Math.round(profitRatePercent * NUMBER_FOR_ROUND) / NUMBER_FOR_ROUND;
    }

    public static long calculateTotalPrizeMoney(Map<RankMessage, Integer> winningResult) {
        return winningResult.keySet().stream()
                .mapToLong(ranking -> ranking.calculatePrizeMoney(winningResult.get(ranking)))
                .sum();
    }
}
