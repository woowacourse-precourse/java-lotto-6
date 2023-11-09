package lotto.model;

import static java.util.Comparator.comparing;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private static final BigDecimal PERCENTAGE_MULTIPLIER = BigDecimal.valueOf(100);
    private static final int INITIAL_SCALE = 1;
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

    private final List<WinningSummary> summaries;

    public WinningResult() {
        this.summaries = new ArrayList<>();
    }

    public void addItem(final WinningSummary summary) {
        summaries.add(summary);
    }

    public List<WinningSummary> getResults() {
        return summaries.stream()
                .sorted(comparing(WinningSummary::prize))
                .toList();
    }

    public BigDecimal sumUpWinningAmount() {
        return BigDecimal.valueOf(calculateTotalAmount());
    }

    private long calculateTotalAmount() {
        return summaries.stream()
                .mapToLong(summary -> summary.frequency() * summary.prize())
                .sum();
    }

    public BigDecimal calculateProfitRate(final Money money) {
        return sumUpWinningAmount()
                .multiply(PERCENTAGE_MULTIPLIER)
                .divide(money.getAmount(), INITIAL_SCALE, DEFAULT_ROUNDING);
    }
}
