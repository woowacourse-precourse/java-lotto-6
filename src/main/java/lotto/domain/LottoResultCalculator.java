package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private final WinningNumbers winningNumbers;

    public LottoResultCalculator(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Map<Rank, Integer> calculateResults(List<Lotto> lottos) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto);
            boolean matchBonus = winningNumbers.matchBonus(lotto);

            Rank rank = Rank.valueOf(matchCount, matchBonus);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return results;
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
