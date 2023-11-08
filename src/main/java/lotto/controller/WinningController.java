package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.Budget;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningScores;
import lotto.service.BonusNumberService;
import lotto.service.WinningNumbersService;
import lotto.service.WinningService;
import lotto.view.GameView;

public class WinningController {
    private final WinningNumbersService winningNumbersService;
    private final BonusNumberService bonusNumberService;
    private final WinningService winningService;
    private final GameView gameView;

    public WinningController() {
        winningNumbersService = new WinningNumbersService();
        bonusNumberService = new BonusNumberService();
        winningService = new WinningService();
        gameView = new GameView();
    }

    public WinningNumbers createWinningNumbers() {
        gameView.printInputWinningNumbersMessage();
        WinningNumbers winningNumbers = winningNumbersService.createWinningNumbers();

        return winningNumbers;
    }

    public BonusNumber createBonusNumber(final WinningNumbers winningNumbers) {
        gameView.printInputBonusNumberMessage();

        BonusNumber bonusNumber = bonusNumberService.createBonusNumber(winningNumbers);
        return bonusNumber;
    }

    public WinningScores compileStatistic(final Lottos lottos, final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        WinningScores winningScores = winningService.calWinningScores(lottos, winningNumbers, bonusNumber);
        String winningStatisticOutput = winningService.getWinningScoresResult(winningScores);
        gameView.printWinningStatistic(winningStatisticOutput);

        return winningScores;
    }

    public void printProfit(final WinningScores winningScores, final Budget budget){
        double profit = winningService.getReturnOfLottos(winningScores, budget);

        gameView.printROI(profit);
    }

}
