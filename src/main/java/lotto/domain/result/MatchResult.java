package lotto.domain.result;

import java.util.Map;

public class MatchResult {
    private final Map<Integer, Integer> matchCounts;
    private final int bonusMatchCount;

    public MatchResult(Map<Integer, Integer> matchCounts, int bonusMatchCount) {
        this.matchCounts = matchCounts;
        this.bonusMatchCount = bonusMatchCount;
    }

    public int getMatchCounts(int count) {
        return matchCounts.getOrDefault(count, 0);
    }

    public int getBonusMatchCount() {
        return bonusMatchCount;
    }
}

