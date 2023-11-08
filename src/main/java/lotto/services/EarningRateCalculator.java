package lotto.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;
import lotto.enums.LottoPrize;

public class EarningRateCalculator {
    public static BigDecimal calculate(EnumMap<LottoPrize, Integer> prizes, int purchaseMoney) {
        BigDecimal totalWinnings = calculateTotalWinnings(prizes);
        BigDecimal earningRate = calculateEarningRateInPercentage(totalWinnings, purchaseMoney);
        return earningRate.setScale(1, RoundingMode.HALF_UP);
    }

    private static BigDecimal calculateTotalWinnings(EnumMap<LottoPrize, Integer> prizes) {
        BigDecimal totalWinnings = BigDecimal.ZERO;

        for (Map.Entry<LottoPrize, Integer> entry : prizes.entrySet()) {
            LottoPrize prize = entry.getKey();
            int winningCount = entry.getValue();
            double prizeAmount = prize.getPrizeAmount();

            if (winningCount > 0) {
                BigDecimal prizeTotal = BigDecimal.valueOf(prizeAmount).multiply(BigDecimal.valueOf(winningCount));
                totalWinnings = totalWinnings.add(prizeTotal);
            }
        }
        return totalWinnings;
    }

    private static BigDecimal calculateEarningRate(BigDecimal totalWinnings, int purchaseMoney) {
        return totalWinnings.divide(BigDecimal.valueOf(purchaseMoney), 3, RoundingMode.DOWN);
    }

    public static BigDecimal calculateEarningRateInPercentage(BigDecimal totalWinnings, int purchaseMoney) {
        BigDecimal earningRate = calculateEarningRate(totalWinnings, purchaseMoney);
        return earningRate.multiply(BigDecimal.valueOf(100));
    }
}
