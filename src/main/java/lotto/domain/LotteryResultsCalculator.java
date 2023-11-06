package lotto.domain;

public class LotteryResultsCalculator {

    private final LotteryOperator operator;

    public LotteryResultsCalculator(LotteryOperator operator) {
        this.operator = operator;
    }

    public long calculate(LotteryReceipt receipt) {
        LotteryResults results = LotteryResults.emptyResults();
        for (PurchasedLottery lottery : receipt) {
            results.applyResults(operator.getResult(lottery));
        }
        return results.getTotalAmount();
    }

}
