package lotto.domain.calculator;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.winningnumber.WinningNumbers;

public class LottoResultCalculator {

    public Map<Rank, Integer> calculateResults(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            Rank rank = determineRank(lotto, winningNumbers);
            updateResults(results, rank);
        }

        return results;
    }

    private Rank determineRank(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = getMatchCount(lotto, winningNumbers);
        boolean matchBonus = winningNumbers.matchBonus(lotto);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int getMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        return (int) lotto.numbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void updateResults(Map<Rank, Integer> results, Rank rank) {
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }
}
