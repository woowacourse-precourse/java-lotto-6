package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class LottoResult {
    private final HashMap<WinningCriteria, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>(){{
            put(WinningCriteria.FIRST, 0);
            put(WinningCriteria.SECOND, 0);
            put(WinningCriteria.THIRD, 0);
            put(WinningCriteria.FOURTH, 0);
            put(WinningCriteria.FIFTH, 0);
        }};
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
            countWinningType(getMatchNumbers(lotto, winningLotto), checkMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void countWinningType(int matchNumber, boolean matchBonus) {
        WinningCriteria type = WinningCriteria.getWinningType(matchNumber, matchBonus);
        result.put(type, result.getOrDefault(type, 0) + 1);
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (WinningCriteria type : result.keySet()) {
            totalPrize += type.getPrize();
        }
        return totalPrize;
    }

    public double calculateRateOfReturn(int amount) {
        double totalPrize = calculateTotalPrize();
        return convertTwoDecimalPlaces((totalPrize / amount) * 100);
    }

    private double convertTwoDecimalPlaces(double rate) {
        return Double.parseDouble(String.format("%.1f", rate));
    }
}
