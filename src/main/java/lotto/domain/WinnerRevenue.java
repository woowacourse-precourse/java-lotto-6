package lotto.domain;

import java.util.List;

public class WinnerRevenue {

    private static final int WINNING_REVENUE_START_INDEX = 0;
    private static final int INIT_VALUE = 0;
    private static final int TWO_DOT_ROUND_VALUE = 100;

    private final long totalRevenue;

    public WinnerRevenue(List<Long> correctWinningsCount, List<Boolean> correctBonuses) {
        this.totalRevenue = calculateRevenue(correctWinningsCount, correctBonuses);
    }

    private long calculateRevenue(List<Long> correctWinningsCount, List<Boolean> correctBonuses) {
        long revenue = INIT_VALUE;

        for (int i = WINNING_REVENUE_START_INDEX; i < correctWinningsCount.size(); i++) {
            Long correctWinningCount = correctWinningsCount.get(i);
            boolean correctBonus = correctBonuses.get(i);

            WinningStatistics winningConfirmResult = WinningStatistics.confirm(correctWinningCount, correctBonus);
            long price = winningConfirmResult.getWinningPrice();
            revenue += price;
        }

        return revenue;
    }

    public long getTotalRevenue() {
        return totalRevenue;
    }

    public static double calculateRounds(double price) {
        return (double) Math.round(price * TWO_DOT_ROUND_VALUE) / TWO_DOT_ROUND_VALUE;
    }

    public double calculateRateOfRevenue(int userPrice) {
        double totalPriceDivideByUserPrice =  (double) this.totalRevenue / userPrice;
        double rateOfRevenue = totalPriceDivideByUserPrice * 100;

        return rateOfRevenue;
    }

    public RevenueDto generateRevenueDto(int userPrice) {
        double rateOfRevenue = calculateRateOfRevenue(userPrice);
        return RevenueDto.from(rateOfRevenue);
    }

}
