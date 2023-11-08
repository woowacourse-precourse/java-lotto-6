package lotto.controller;

import lotto.domain.Budget;
import lotto.service.BudgetService;
import lotto.view.GameView;

public class BudgetController {
    private final BudgetService budgetService;
    private final GameView gameView;

    public BudgetController(){
        budgetService = new BudgetService();
        gameView = new GameView();
    }

    public Budget createBudget(){
        gameView.printInputBudgetMessage();

        Budget budget = budgetService.createBudget();
        return budget;
    }
}
