package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoMatcher;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Budget budget = getValidInput(inputView::inputBudget);
        List<Lotto> purchasedLottos = getValidInput(()->purchaseLottos(budget));
        WinningLotto winningLotto = getValidInput(inputView::inputWinningLotto);
        printLottoResult(purchasedLottos, winningLotto, budget);
    }

    private <T> T getValidInput(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottos(Budget budget) {
        List<Lotto> purchasedLottos = new LottoGenerator().generate(budget);
        outputView.printTicketNumber(budget.calculateLottoCount());
        outputView.printUserLottos(purchasedLottos);
        return purchasedLottos;
    }

    private void printLottoResult(List<Lotto> purchasedLottos, WinningLotto winningLotto,
        Budget budget) {
        LottoResult lottoResult = new LottoMatcher(winningLotto).matchLottos(purchasedLottos);
        outputView.printLottoResult(lottoResult, budget.inputMoney());
    }


}
