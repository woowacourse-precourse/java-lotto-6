package lotto.v3.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final List<List<Integer>> purchasedNumbers;
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<LottoRank, Integer> matchCounts;

    public LottoResult(List<List<Integer>> purchasedNumbers, Set<Integer> winningNumbers, int bonusNumber) {
        this.purchasedNumbers = purchasedNumbers;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.matchCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            matchCounts.put(rank, 0);
        }
        calculateResults();
    }

    private void calculateResults() {
        for (List<Integer> numbers : purchasedNumbers) {
            int matches = (int) winningNumbers.stream().filter(numbers::contains).count();

            if (matches < LottoRank.FIFTH.getMatchCount()) {
                continue;
            }

            boolean bonusMatch = numbers.contains(bonusNumber) && matches == LottoRank.SECOND.getMatchCount();

            LottoRank rank = null;
            try {
                rank = LottoRank.valueOf(matches, bonusMatch);
            } catch (IllegalArgumentException e) {
                continue;
            }

            matchCounts.put(rank, matchCounts.get(rank) + 1);
        }
    }

    public Map<LottoRank, Integer> getMatchCounts() {
        return matchCounts;
    }
}
