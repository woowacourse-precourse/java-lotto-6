package lotto.controller;

import java.util.List;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.LottoPurchaser;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaser lottoPurchaser;

    public LottoController(final InputView inputView, final OutputView outputView,
        final LottoPurchaser lottoPurchaser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoPurchaser = lottoPurchaser;
    }

    public void run() {
        try {
            Budget budget = inputView.inputBudget();
            List<Lotto> purchasedLottos = purchaseLottos(budget);
            WinningLotto winningLotto = inputView.inputWinningLotto();
            printLottoResult(purchasedLottos, winningLotto, budget);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private List<Lotto> purchaseLottos(Budget budget) {
        List<Lotto> purchasedLottos = lottoPurchaser.purchase(budget);
        outputView.printUserLottos(purchasedLottos);
        return purchasedLottos;
    }

    private void printLottoResult(List<Lotto> purchasedLottos, WinningLotto winningLotto,
        Budget budget) {
        LottoResult lottoResult = winningLotto.matchLottos(purchasedLottos);
        outputView.printLottoResult(lottoResult, budget.inputMoney());
    }


}
