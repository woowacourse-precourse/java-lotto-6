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
    private volatile static WinningController INSTANCE;
    private final WinningNumbersService winningNumbersService;
    private final BonusNumberService bonusNumberService;
    private final WinningService winningService;
    private final GameView gameView;

    private WinningController() {
        winningNumbersService = WinningNumbersService.getInstance();
        bonusNumberService = BonusNumberService.getInstance();
        winningService = WinningService.getInstance();
        gameView = GameView.getInstance();
    }

    public static WinningController getInstance() {
        if (INSTANCE == null) {
            synchronized (WinningController.class) {
                createInstance();
            }
        }

        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WinningController();
        }
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

    public void printProfitRatio(final WinningScores winningScores, final Budget budget) {
        double profitRatio = winningService.calProfitRatio(winningScores, budget);
        gameView.printProfitRatio(profitRatio);
    }

}
