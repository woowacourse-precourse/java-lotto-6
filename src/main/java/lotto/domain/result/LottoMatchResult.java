package lotto.domain.result;

import static lotto.domain.constants.LottoConstants.MATCH_FIVE_AND_BONUS_COUNT;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {
    private final Map<Integer, Integer> matchCounts = new HashMap<>();
    private int bonusMatchCount = 0;

    public int getMatchCounts(int count) {
        return matchCounts.getOrDefault(count, 0);
    }

    public int getBonusMatchCount() {
        return bonusMatchCount;
    }

    public void updateMatchResult(int count, boolean bonusMatched) {
        if (count == MATCH_FIVE_AND_BONUS_COUNT && bonusMatched) {
            bonusMatchCount++;
        }
        matchCounts.put(count, matchCounts.getOrDefault(count, 0) + 1);
    }
}
