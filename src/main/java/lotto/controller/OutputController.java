package lotto.controller;

import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.ProfitStats;
import lotto.model.TotalResult;
import lotto.view.OutputView;

import java.util.List;

public class OutputController {
    public void printPurchaseInfo(Budget budget, List<Lotto> purchaseLottos) {
        OutputView.printPurchaseAmount(budget.getLottoAmount());
        OutputView.printLottoNumbers(purchaseLottos);
    }

    public void printWinningStats(TotalResult totalResult, ProfitStats profitStats) {
        OutputView.printTotalLottoResult(totalResult);
        OutputView.printEarningRate(profitStats);
    }
}
