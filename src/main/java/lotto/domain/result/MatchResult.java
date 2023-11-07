package lotto.domain.result;

import static lotto.utils.constants.LottoConstants.MATCH_FIVE_AND_BONUS_COUNT;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {
    private final Map<Integer, Integer> matchCounts;
    private final int bonusMatchCount;

    public MatchResult() {
        this.matchCounts = new HashMap<>();
        this.bonusMatchCount = 0;
    }

    private MatchResult(Map<Integer, Integer> matchCounts, int bonusMatchCount) {
        this.matchCounts = matchCounts;
        this.bonusMatchCount = bonusMatchCount;
    }

    public int getMatchCounts(int count) {
        return matchCounts.getOrDefault(count, 0);
    }

    public int getBonusMatchCount() {
        return bonusMatchCount;
    }

    public MatchResult updateMatchResult(int count, boolean bonusMatched) {
        Map<Integer, Integer> newMatchCounts = new HashMap<>(this.matchCounts);
        newMatchCounts.put(count, newMatchCounts.getOrDefault(count, 0) + 1);

        int newBonusMatchCount = this.bonusMatchCount;
        if (count == MATCH_FIVE_AND_BONUS_COUNT && bonusMatched) {
            newBonusMatchCount++;
            newMatchCounts.put(5, newMatchCounts.getOrDefault(5, 0) - 1);
        }
        return new MatchResult(newMatchCounts, newBonusMatchCount);
    }
}

