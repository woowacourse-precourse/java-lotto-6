package lotto;

import java.util.Map;

public class ProfitCalculator {
    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 5000;

    public Double calculateProfitRate(Map<Integer, Integer> winningStatistics, String buying) {
        Double prizeAmount = calculatePrizeAmount(winningStatistics);
        Double buyingAmount = Double.parseDouble(buying);
        return prizeAmount / buyingAmount * 100;
    }

    private Double calculatePrizeAmount(Map<Integer, Integer> winningStatistics) {
        Double prizeAmount = 0.0;
        prizeAmount += winningStatistics.get(6) * FIRST_PRIZE;
        prizeAmount += winningStatistics.get(2) * SECOND_PRIZE;
        prizeAmount += winningStatistics.get(5) * THIRD_PRIZE;
        prizeAmount += winningStatistics.get(4) * FOURTH_PRIZE;
        prizeAmount += winningStatistics.get(3) * FIFTH_PRIZE;

        return prizeAmount;
    }
}
