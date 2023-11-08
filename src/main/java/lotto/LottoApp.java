package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoAppController;
import lotto.controller.OutputController;
import lotto.model.*;

import java.util.List;


public class LottoApp {
    private final LottoAppController lottoAppController = new LottoAppController();
    private final InputController inputController = new InputController();
    private final OutputController outputController = new OutputController();

    public void run() {
        Budget budget = inputController.createBudgetByUserInput();
        List<Lotto> lottos = lottoAppController.purchaseLottos(budget);
        outputController.printPurchaseInfo(budget, lottos);

        WinningLotto win = inputController.createWinningLottoByUserInput();
        TotalResult totalResult = lottoAppController.processLottoResult(win, lottos);
        ProfitStats profitStats = lottoAppController.createProfitStats(budget, totalResult);

        outputController.printWinningStats(totalResult, profitStats);
    }
}
