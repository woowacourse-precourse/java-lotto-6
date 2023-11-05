package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class ResultAnalyzer {
    private final RankCounter counter = new RankCounter();

    public RankCounter analyze(List<Lotto> lottos, Lotto winningNumber, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = winningNumber.compare(lotto);
            boolean matchBonus = false;
            if (matchCount == 5) {
                matchBonus = lotto.contains(bonusNumber);
            }
            Rank rank = findRank(matchCount, matchBonus);
            counter.increment(rank);
        }
        return counter;
    }

    private Rank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount && rank.getMatchBonus() == matchBonus)
                .findFirst()
                .orElse(Rank.OUT_OF_RANKS);
    }

    public int calculateTotalProfit(RankCounter counter) {
        return counter.getCounter().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
