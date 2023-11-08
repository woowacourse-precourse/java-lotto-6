package lotto;

import lotto.controller.AppController;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.ProfitStats;
import lotto.model.TotalResult;

import java.util.List;

import static lotto.view.OutputView.*;

public class App {
    private final AppController appController = new AppController();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        Budget budget = appController.createBudget();
        int lottoAmount = budget.getLottoAmount();
        lottoGenerator.generate(lottoAmount);

        printPurchaseAmount(lottoAmount);
        printLottoNumbers(lottoGenerator.getLottos());

        WinningLotto win = appController.createWinningLotto();

        List<Lotto> lottos = lottoGenerator.getLottos();
        TotalResult totalResult = appController.processLottoResult(win, lottos);
        ProfitStats profitStats = appController.createProfitStats(budget, totalResult);

        printTotalLottoResult(totalResult);
        printEarningRate(profitStats);
    }
}
