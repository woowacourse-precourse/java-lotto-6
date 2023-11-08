package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LotteryResultsCalculator {

    private final LotteryOperator operator;

    public LotteryResultsCalculator(LotteryOperator operator) {
        this.operator = Objects.requireNonNull(operator);
    }

    public LotteryResults getTotalResults(LotteryReceipt receipt) {
        LotteryResults results = LotteryResults.emptyResults(operator.getRankings());
        for (PurchasedLottery lottery : receipt) {
            results.applyResults(operator.getResult(lottery));
        }
        return results;
    }

    public LotteryResults getTotalResults(List<LotteryReceipt> receipts) {
        return receipts.stream()
                .map(receipt -> getTotalResults(receipt))
                .reduce((r1, r2) -> r1.applyResults(r2))
                .get();
    }
}
