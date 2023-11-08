package lotto.controller;

import lotto.domain.Budget;
import lotto.service.BudgetService;
import lotto.view.GameView;

public class BudgetController {
    private volatile static BudgetController INSTANCE;
    private final BudgetService budgetService;
    private final GameView gameView;

    private BudgetController() {
        budgetService = BudgetService.getInstance();
        gameView = GameView.getInstance();
    }

    public static BudgetController getInstance() {
        if (INSTANCE == null) {
            synchronized (BudgetController.class) {
                createInstance();
            }
        }

        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BudgetController();
        }
    }

    public Budget createBudget() {
        gameView.printInputBudgetMessage();

        Budget budget = budgetService.createBudget();
        return budget;
    }
}
