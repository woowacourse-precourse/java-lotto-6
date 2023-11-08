package lotto.service;

import lotto.domain.*;

public class WinningService {
    private volatile static WinningService INSTANCE;

    private WinningService() {
    }

    public static WinningService getInstance() {
        if (INSTANCE == null) {
            synchronized (WinningService.class) {
                createInstance();
            }
        }

        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WinningService();
        }
    }

    public WinningScores calWinningScores(final Lottos lottos, final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        return lottos.calWinningScores(winningNumbers, bonusNumber);
    }

    public String getWinningScoresResult(final WinningScores winningScores) {
        return winningScores.toString();
    }

    public double calProfitRatio(final WinningScores winningScores, final Budget budget) {
        long profitSum = winningScores.calProfitSum();

        return budget.calProfitRatio(profitSum);
    }

}
