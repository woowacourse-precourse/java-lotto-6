package lotto.service;

import java.util.List;
import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryResults;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.User;
import lotto.service.dto.CalculationOutcome;

public class CalculateResultService {

    private final LotteryResultsCalculator calculator;

    public CalculateResultService(LotteryResultsCalculator calculator) {
        this.calculator = calculator;
    }

    public CalculationOutcome calculate(User user) {
        List<LotteryReceipt> receipts = user.getReceipts();

        LotteryResults results = calculator.getTotalResults(receipts);
        long resultAmount = results.getTotalAmount();
        long purchaseAmount = calculatePurchaseAmount(receipts);

        double earningRate = ((double) resultAmount / (double) purchaseAmount) * 100;

        return new CalculationOutcome(results.toList(), earningRate);
    }

    private long calculatePurchaseAmount(List<LotteryReceipt> receipts) {
        return receipts.stream()
                .mapToLong(LotteryReceipt::getPurchasedAmount)
                .sum();
    }

}
