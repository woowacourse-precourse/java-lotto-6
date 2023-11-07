package lotto.controller;


import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.LottoBundle;
import lotto.model.ProfitCalculator;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.view.OutputView;

public class ProfitController {
    private final LottoBundle lottoBundle;
    private final PurchaseAmount amount;

    public ProfitController(LottoBundle lottoBundle, PurchaseAmount amount) {
        this.lottoBundle = lottoBundle;
        this.amount = amount;
    }

    public void displayProfitReport(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        Map<String, Integer> compareResult = displayStatisticReport(winningNumbers, bonusNumber);
        long totalPrize = lottoBundle.totalPrize(compareResult);
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

    private double calculateProfit(long totalPrize) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculateProfit(totalPrize, amount);
    }
}
