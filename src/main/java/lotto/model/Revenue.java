package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.RankCount;

public class Revenue {
    private final RankCount rankCount;
    private final String revenue;
    private final Budget budget;

    public Revenue(RankCount rankCount, Budget budget) {
        this.rankCount = rankCount;
        this.budget = budget;
        this.revenue = calculateRevenue();

    }

    public String getRevenue() {
        return revenue;
    }

    private int calculateTotalRevenueSum() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.FAIL)
                .mapToInt(rank -> rankCount.getCounts(rank) * rank.getAmount())
                .sum();
    }

    private String calculateRevenue(){
        int totalSum = calculateTotalRevenueSum();
        BigDecimal revenuePercentage = new BigDecimal(totalSum)
                .divide(new BigDecimal(budget.getValue()), 4, RoundingMode.HALF_EVEN)
                .multiply(new BigDecimal("100"));
        return formatRevenue(revenuePercentage.floatValue());
    }

    private String formatRevenue(float revenue) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(revenue);
    }

}
