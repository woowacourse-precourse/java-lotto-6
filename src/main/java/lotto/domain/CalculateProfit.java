package lotto.domain;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

import static lotto.consts.ConstsString.SCALE;
import static lotto.consts.ConstsString.FINAL_SCALE;
import static lotto.consts.ConstsString.ZERO_TICKET;
import static lotto.consts.ConstsString.TICKET_PRICE;
import static lotto.consts.ConstsString.HUNDRED;

public class CalculateProfit {
    private final LinkedHashMap<LottoRank, Integer> winningCount;
    private final long countTickets;

    public CalculateProfit(LinkedHashMap<LottoRank, Integer> winnerCount, long totalTickets) {
        this.winningCount = winnerCount;
        this.countTickets = totalTickets;
    }

    public BigDecimal calculateRatio() {
        if (countTickets == ZERO_TICKET) {
            return BigDecimal.ZERO;
        }

        long totalPrize = calculateTotalPrize();
        BigDecimal totalEarnings = BigDecimal.valueOf(totalPrize);
        BigDecimal totalSpent = calculateTotalSpent();

        return calculateProfitPercentage(totalEarnings, totalSpent);
    }

    private long calculateTotalPrize() {
        return winningCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private BigDecimal calculateTotalSpent() {
        return BigDecimal.valueOf((long) TICKET_PRICE * countTickets);
    }

    private BigDecimal calculateProfitPercentage(BigDecimal totalEarnings, BigDecimal totalSpent) {
        return totalEarnings.divide(totalSpent, SCALE, RoundingMode.HALF_UP)
                .multiply(HUNDRED)
                .setScale(FINAL_SCALE, RoundingMode.HALF_UP);
    }

}