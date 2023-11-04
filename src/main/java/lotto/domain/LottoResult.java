package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class LottoResult {
    private final HashMap<WinningCriteria, Integer> result;

    public LottoResult(List<Lotto> purchaseLotto, Lotto winningNumbers, int bonusNumber) {
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
            countWinningType(getMatchNumbers(lotto, winningLotto), checkMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void countWinningType(int matchNumber, boolean matchBonus) {
        WinningCriteria type = WinningCriteria.getWinningType(matchNumber, matchBonus);
        result.put(type, result.getOrDefault(type, 0) + 1);
    }
}
