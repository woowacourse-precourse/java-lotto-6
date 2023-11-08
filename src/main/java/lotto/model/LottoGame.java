package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public List<WinningResult> calculateWinningResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        List<WinningResult> results = new ArrayList<>();
        for (Lotto lotto : purchasedLottos) {
            int matchingCount = calculateMatchingCount(lotto, winningNumbers);
            boolean hasBonusNumber = lotto.contains(bonusNumber);

            results.add(new WinningResult(matchingCount, hasBonusNumber));
        }
        return results;
    }

    private int calculateMatchingCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }
}