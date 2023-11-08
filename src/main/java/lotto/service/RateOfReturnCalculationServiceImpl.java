package lotto.service;

import java.util.Map;
import lotto.domain.WinningStatus;

public class RateOfReturnCalculationServiceImpl implements RateOfReturnCalculationService {
    @Override
    public double calculateRateOfReturn(long totalPrice, Map<WinningStatus, Integer> winningStatistics) {
        long totalWinnings = calculateTotalWinnings(winningStatistics);
        double rateOfReturn = calculateRateOfReturn(totalWinnings, totalPrice);
        return roundRateOfReturn(rateOfReturn);
    }

    private long calculateTotalWinnings(Map<WinningStatus, Integer> winningStatistics) {
        return winningStatistics.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateRateOfReturn(long totalWinnings, long totalPrice) {
        double rateOfReturn = (totalWinnings / (double) totalPrice) * 100;
        return rateOfReturn;
    }

    private double roundRateOfReturn(double rateOfReturn) {
        return Math.round(rateOfReturn * 10.0) / 10.0;
    }
}
