package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

public class ProfitMeter {

    private static final int TICKET_PRICE = 1000;
    private static final int SCALE = 4;
    private static final int FINAL_SCALE = 1;
    private static final int ZERO_TICKET = 0;

    private static final BigDecimal HUNDRED = new BigDecimal(100);

    private final LinkedHashMap<LottoRank, Integer> winnerCount;
    private final long totalTickets;

    public ProfitMeter(LinkedHashMap<LottoRank, Integer> winnerCount, long totalTickets) {
        this.winnerCount = winnerCount;
        this.totalTickets = totalTickets;
    }

    public BigDecimal calculateYield() {
        if (totalTickets == ZERO_TICKET) {
            return BigDecimal.ZERO;
        }

        long totalPrize = calculateTotalPrize();
        BigDecimal totalEarnings = BigDecimal.valueOf(totalPrize);
        BigDecimal totalSpent = calculateTotalSpent();

        return calculateProfitPercentage(totalEarnings, totalSpent);
    }

    private long calculateTotalPrize() {
        return winnerCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private BigDecimal calculateTotalSpent() {
        return BigDecimal.valueOf((long) TICKET_PRICE * totalTickets);
    }

    private BigDecimal calculateProfitPercentage(BigDecimal totalEarnings, BigDecimal totalSpent) {
        return totalEarnings.divide(totalSpent, SCALE, RoundingMode.HALF_UP)
                .multiply(HUNDRED)
                .setScale(FINAL_SCALE, RoundingMode.HALF_UP);
    }

}
