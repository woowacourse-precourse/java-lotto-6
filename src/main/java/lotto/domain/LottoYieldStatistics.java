package lotto.domain;

import java.util.Map;

public class LottoYieldStatistics {
    private static final int HUNDRED = 100;

    public double calculate(Money moneySpent, Map<WinningGrade, Integer> winningNumbers) {
        int totalPrizeMoney = WinningGrade.getWinningAmount(winningNumbers);
        int moneySpentOnLotto = moneySpent.getValue();
        return calculateLottoYield(totalPrizeMoney, moneySpentOnLotto);
    }

    private double calculateLottoYield(int totalPrizeMoney, int moneySpentOnLotto) {
        return ((double) totalPrizeMoney / moneySpentOnLotto) * HUNDRED;
    }
}
