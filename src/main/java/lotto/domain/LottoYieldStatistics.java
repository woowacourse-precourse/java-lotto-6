package lotto.domain;

import java.util.Map;

public class LottoYieldStatistics {

    public double calculate(Money moneySpent, Map<WinningGrade, Integer> winningNumbers) {
        int totalPrizeMoney = WinningGrade.getWinningAmount(winningNumbers);
        int moneySpentOnLotto = moneySpent.getValue();
        return calculateLottoYield(totalPrizeMoney, moneySpentOnLotto);
    }

    private double calculateLottoYield(int totalPrizeMoney, int moneySpentOnLotto) {
        return ((double) totalPrizeMoney / moneySpentOnLotto) * 100;
    }
}
