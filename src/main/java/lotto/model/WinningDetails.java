package lotto.model;

import static java.util.Comparator.comparing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WinningDetails {

    private final List<WinningSummary> summaries;

    public WinningDetails() {
        this.summaries = new ArrayList<>();
    }

    public void addItem(final WinningSummary summary) {
        summaries.add(summary);
    }

    public List<WinningSummary> getResults() {
        return summaries.stream()
                .sorted(comparing(WinningSummary::numberOfMatches))
                .toList();
    }

    public BigDecimal sumUpWinningAmount() {
        return BigDecimal.valueOf(calculateTotalAmount());
    }

    private long calculateTotalAmount() {
        return summaries.stream()
                .mapToLong(summary -> summary.count() * summary.prize())
                .sum();
    }
}
