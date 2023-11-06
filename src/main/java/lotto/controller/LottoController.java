package lotto.controller;

import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.service.BudgetService;
import lotto.service.LottoService;
import lotto.view.GameView;

public class LottoController {
    private final BudgetService budgetService;
    private final LottoService lottoService;
    private final GameView gameView;

    public LottoController() {
        budgetService = new BudgetService();
        lottoService = new LottoService();
        gameView = new GameView();
    }

    public void start() {
        gameView.printInputBudgetMessage();
        Budget budget = budgetService.createBudget();

        //todo: view에서 프린트하는 과정에 책임을 더 주는 건 어떨까? -> 현재에는 단순 출력만 하도록 하는데 역할을 더 줘서 처리를 하게 하는 건 어떨까
        Lottos lottos = lottoService.createLottos(budget);
        int lottosSize = lottoService.getLottosSize(lottos);
        gameView.printLottosSize(lottosSize);

        String lottosNumbers = lottoService.getLottosNumbers(lottos);
        gameView.printLottosNumbers(lottosNumbers);
    }
}
