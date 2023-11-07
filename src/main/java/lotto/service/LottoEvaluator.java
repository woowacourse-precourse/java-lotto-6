package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoEvaluator {

    public Map<Prize, Integer> evaluate(List<Lotto> purchasedLotto, WinningNumbers winningNumbers) {
        Map<Prize, Integer> results = new HashMap<>();
        for (Lotto lotto : purchasedLotto) {
            int matchCount = countMatches(lotto, winningNumbers.getWinningNumbers());
            boolean matchBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
            Prize prize = Prize.valueOf(matchCount, matchBonus);
            results.put(prize, results.getOrDefault(prize, 0) + 1);
        }
        return results;
    }

    private int countMatches(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
