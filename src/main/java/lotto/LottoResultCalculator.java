package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    public Map<Prize, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Prize, Integer> results = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            boolean isBonusMatch = matchCount == 5 && lotto.getNumbers().contains(bonusNumber);
            Prize prize = Prize.determinePrize(matchCount, isBonusMatch);
            results.merge(prize, 1, Integer::sum);
        }
        return results;
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }
}