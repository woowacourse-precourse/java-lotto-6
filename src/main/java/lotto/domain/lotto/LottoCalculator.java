package lotto.domain.lotto;

import lotto.domain.Money;
import lotto.domain.winning.WinningGrade;

import java.util.Map;

public class LottoCalculator {
    private static final int HUNDRED = 100;

    public double calculate(Money moneySpent, Map<WinningGrade, Integer> winningResults) {
        int totalPrizeMoney = calculateTotalPrizeMoney(winningResults);
        int moneySpentOnLotto = moneySpent.value();
        return calculateLottoYield(totalPrizeMoney, moneySpentOnLotto);
    }

    public int calculateTotalPrizeMoney(Map<WinningGrade, Integer> winningResults) {
        return winningResults.entrySet().stream()
                .mapToInt(LottoCalculator::calculatePrizeMoney)
                .sum();
    }

    private static int calculatePrizeMoney(Map.Entry<WinningGrade, Integer> result) {
        Integer winningCount = result.getValue();
        int prizeMoney = result.getKey().getPrizeMoney();
        return prizeMoney * winningCount;
    }

    private double calculateLottoYield(int totalPrizeMoney, int moneySpentOnLotto) {
        return ((double) totalPrizeMoney / moneySpentOnLotto) * HUNDRED;
    }
}
