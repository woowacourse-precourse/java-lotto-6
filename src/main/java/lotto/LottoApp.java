package lotto;

import lotto.controller.LottoAppController;
import lotto.model.*;

import java.util.List;

import static lotto.view.OutputView.*;

public class LottoApp {
    private final LottoAppController lottoAppController = new LottoAppController();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        Budget budget = lottoAppController.createBudget();
        int lottoAmount = budget.getLottoAmount();
        lottoGenerator.generate(lottoAmount);

        printPurchaseAmount(lottoAmount);
        printLottoNumbers(lottoGenerator.getLottos());

        WinningLotto win = lottoAppController.createWinningLotto();

        List<Lotto> lottos = lottoGenerator.getLottos();
        TotalResult totalResult = lottoAppController.processLottoResult(win, lottos);
        ProfitStats profitStats = lottoAppController.createProfitStats(budget, totalResult);

        printTotalLottoResult(totalResult);
        printEarningRate(profitStats);
    }
}
