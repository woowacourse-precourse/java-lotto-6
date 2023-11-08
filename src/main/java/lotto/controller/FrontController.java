package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningScores;

public class FrontController {

    private final BudgetController budgetController;
    private final LottoController lottoController;
    private final WinningController winningController;

    public FrontController() {
        budgetController = new BudgetController();
        lottoController = new LottoController();
        winningController = new WinningController();
    }

    public void gameStart() {
        Budget budget = budgetController.createBudget();
        Lottos lottos = lottoController.createLottos(budget);
        lottoController.printLottos(lottos);

        WinningNumbers winningNumbers = winningController.createWinningNumbers();
        BonusNumber bonusNumber = winningController.createBonusNumber(winningNumbers);

        WinningScores winningScores = winningController.compileStatistic(lottos, winningNumbers, bonusNumber);
        winningController.printProfit(winningScores, budget);
    }
}
