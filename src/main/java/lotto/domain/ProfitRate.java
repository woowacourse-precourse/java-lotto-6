package lotto.domain;

import java.util.Map;

public class ProfitRate {

    private static final int FIRST_PRIZE_AMOUNT = 2_000_000_000;
    private static final int SECOND_PRIZE_AMOUNT = 30_000_000;
    private static final int THIRD_PRIZE_AMOUNT = 1_500_000;
    private static final int FOURTH_PRIZE_AMOUNT = 50_000;
    private static final int FIFTH_PRIZE_AMOUNT = 5_000;

    private int totalPrizeAmount = 0;
    private double profitRate = 0;
    public ProfitRate(Map<Rank, Integer> matchRankCount, int purchaseAmount) {
        totalPrizeAmount = calculateTotalPrizeAmount(matchRankCount);
        profitRate = calculateProfitRate(totalPrizeAmount, purchaseAmount);
    }

    public double getProfitRate() {
        return profitRate;
    }

    private int calculateTotalPrizeAmount(Map<Rank, Integer> matchRankCount){
        if (matchRankCount.get(Rank.FIRST) != 0) {
            totalPrizeAmount += matchRankCount.get(Rank.FIRST) * FIRST_PRIZE_AMOUNT;
        } else if (matchRankCount.get(Rank.SECOND) != 0) {
            totalPrizeAmount += matchRankCount.get(Rank.SECOND) * SECOND_PRIZE_AMOUNT;
        } else if (matchRankCount.get(Rank.THIRD) != 0) {
            totalPrizeAmount += matchRankCount.get(Rank.THIRD) * THIRD_PRIZE_AMOUNT;
        } else if (matchRankCount.get(Rank.FOURTH) != 0) {
            totalPrizeAmount += matchRankCount.get(Rank.FOURTH) * FOURTH_PRIZE_AMOUNT;
        } else if (matchRankCount.get(Rank.FIFTH) != 0) {
            totalPrizeAmount += matchRankCount.get(Rank.FIFTH) * FIFTH_PRIZE_AMOUNT;
        }
        return totalPrizeAmount;
    }

    private double calculateProfitRate(int totalPrizeAmount, int purchaseAmount) {
        double profitRate = (totalPrizeAmount / (double) purchaseAmount) * 100;
        profitRate = Math.round(profitRate * 10.0) / 10.0;
        return profitRate;
    }
}
