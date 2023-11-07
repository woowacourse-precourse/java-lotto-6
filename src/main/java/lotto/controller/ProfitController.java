package lotto.controller;

import static lotto.util.Constants.ZERO;

import java.util.Map;
import java.util.Optional;
import lotto.model.BonusNumber;
import lotto.model.LottoBundle;
import lotto.model.ProfitCalculator;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.util.enums.LottoResult;
import lotto.view.OutputView;

public class ProfitController {
    private static final Long LONG_ZERO = 0L;

    private final LottoBundle lottoBundle;
    private final PurchaseAmount amount;

    public ProfitController(LottoBundle lottoBundle, PurchaseAmount amount) {
        this.lottoBundle = lottoBundle;
        this.amount = amount;
    }

    public void displayProfitReport(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        Map<String, Integer> compareResult = displayStatisticReport(winningNumbers, bonusNumber);
        long totalPrize = calculateTotalPrize(compareResult);
        double profit = calculateProfit(totalPrize);
        OutputView.getProfit(profit);
    }

    private Map<String, Integer> displayStatisticReport(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        OutputView.winningStatistics();
        OutputView.separator();
        Map<String, Integer> compareResult = lottoComparator(winningNumbers, bonusNumber);
        compareResult.forEach(OutputView::getResult);
        return compareResult;
    }

    private Map<String, Integer> lottoComparator(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        return lottoBundle.compareLotto(winningNumbers, bonusNumber);
    }

    private long calculateTotalPrize(Map<String, Integer> compareResult) {
        return compareResult.entrySet().stream()
                .filter(this::shouldIncludeEntry)
                .mapToLong(this::calculatePrizeForEntry)
                .sum();
    }

    private boolean shouldIncludeEntry(Map.Entry<String, Integer> entry) {
        Optional<LottoResult> result = LottoResult.fromDescription(entry.getKey());
        return result.isPresent() && entry.getValue() > ZERO;
    }

    private long calculatePrizeForEntry(Map.Entry<String, Integer> entry) {
        Optional<LottoResult> result = LottoResult.fromDescription(entry.getKey());
        return result.map(lottoResult -> (long) lottoResult.getPrize() * entry.getValue()).orElse(LONG_ZERO);
    }

    private double calculateProfit(long totalPrize) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculateProfit(totalPrize, amount);
    }
}
