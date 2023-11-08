package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningScores;

public class FrontController {
    private volatile static FrontController INSTANCE;
    private final BudgetController budgetController;
    private final LottoController lottoController;
    private final WinningController winningController;

    public FrontController() {
        budgetController = BudgetController.getInstance();
        lottoController = LottoController.getInstance();
        winningController = WinningController.getInstance();
    }

    public static FrontController getInstance() {
        if (INSTANCE == null) {
            synchronized (FrontController.class) {
                createInstance();
            }
        }

        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FrontController();
        }
    }

    public void gameStart() {
        Budget budget = budgetController.createBudget();
        Lottos lottos = lottoController.createLottos(budget);
        lottoController.printLottos(lottos);

        WinningNumbers winningNumbers = winningController.createWinningNumbers();
        BonusNumber bonusNumber = winningController.createBonusNumber(winningNumbers);

        WinningScores winningScores = winningController.compileStatistic(lottos, winningNumbers, bonusNumber);
        winningController.printProfitRatio(winningScores, budget);
    }
}
