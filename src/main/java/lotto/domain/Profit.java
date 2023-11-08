package lotto.domain;

import static lotto.constants.Condition.MONEY_UNIT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.vo.response.ProfitResponse;

public class Profit {
    private static final int SCALE = 2;

    private final Double rate;

    public Profit(List<Rank> ranks) {
        this.rate = calculateProfitRate(ranks);
    }

    private Double calculateProfitRate(List<Rank> ranks) {
        long prize = calculatePrize(ranks);
        long paidAmount = calculatePaidAmount(ranks);
        double ratio = (double) prize / paidAmount;
        return toPercentage(ratio);
    }

    private long calculatePrize(List<Rank> ranks) {
        return ranks.stream()
            .mapToLong(rank -> rank.getPrice())
            .sum();
    }

    private long calculatePaidAmount(List<Rank> ranks) {
        return ranks.size() * MONEY_UNIT;
    }

    private double toPercentage(double ratio) {
        BigDecimal bd = new BigDecimal(ratio * 100);
        bd = bd.setScale(SCALE, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public ProfitResponse convertResponse() {
        return new ProfitResponse(rate);
    }
}
