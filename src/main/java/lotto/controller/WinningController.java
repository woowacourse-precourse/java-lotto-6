package lotto.controller;

import lotto.domain.*;
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

    public BonusNumber createBonusNumber(WinningNumbers winningNumbers) {
        gameView.printInputBonusNumberMessage();

        BonusNumber bonusNumber = bonusNumberService.createBonusNumber(winningNumbers);
        return bonusNumber;
    }

    public WinningScores compileStatistic(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        WinningScores winningScores = winningService.calWinningScores(lottos, winningNumbers, bonusNumber);
        String winningStatisticOutput = winningService.getWinningScoresResult(winningScores);
        gameView.printWinningStatistic(winningStatisticOutput);

        return winningScores;
    }

    public void printProfit(WinningScores winningScores, Budget budget){
        double profit = winningService.getReturnOfLottos(winningScores, budget);

        gameView.printROI(profit);
    }

}
