package lotto.v3.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final List<Set<Integer>> purchasedNumbers;
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<LottoRank, Integer> matchCounts;

    public LottoResult(List<Set<Integer>> purchasedNumbers, Set<Integer> winningNumbers, int bonusNumber) {
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
        for (Set<Integer> numbers : purchasedNumbers) {
            int matches = (int) winningNumbers.stream().filter(numbers::contains).count();
            boolean bonusMatch = numbers.contains(bonusNumber) && matches == LottoRank.SECOND.getMatchCount();

            try {
                LottoRank rank = LottoRank.valueOf(matches, bonusMatch);
                matchCounts.put(rank, matchCounts.get(rank) + 1);
            } catch (IllegalArgumentException e) {
                System.out.printf("[ERROR] 일치하는 등수를 찾을 수 없어 결과를 계산할 수 없습니다.");
            }
        }
    }

    public Map<LottoRank, Integer> getMatchCounts() {
        return matchCounts;
    }
}
