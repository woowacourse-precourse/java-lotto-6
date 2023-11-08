package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class LottoResult {
    private final HashMap<WinningCriteria, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public HashMap<WinningCriteria, Integer> getResult() {
        return result;
    }

    public int getMatchNumbers(Lotto purchaseLotto, Lotto winningLotto) {
        return (int)purchaseLotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    public boolean checkMatchBonusNumber(Lotto purchaseLotto, int bonusNumber) {
        return purchaseLotto.getNumbers().contains(bonusNumber);
    }

    public void calculateNumberOfWins(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lottos) {
            countWinningRank(getMatchNumbers(lotto, winningLotto), checkMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void countWinningRank(int matchNumber, boolean matchBonus) {
        WinningCriteria rank = WinningCriteria.getWinningRank(matchNumber, matchBonus);
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (WinningCriteria rank : result.keySet()) {
            totalPrize += rank.getPrize();
        }
        return totalPrize;
    }

    public double calculateRateOfReturn(int amount) {
        double totalPrize = calculateTotalPrize();
        return (totalPrize / amount) * 100;
    }
}
