package lotto.controller;

import lotto.domain.Budget;
import lotto.service.BudgetService;
import lotto.view.GameView;

public class LottoController {
    private final BudgetService budgetService;
    private final GameView gameView;

    public LottoController() {
        budgetService = new BudgetService();
        gameView = new GameView();
    }

    public void start() {
        gameView.printInputBudgetMessage();
        Budget budget = budgetService.createBudget();
    }
}
