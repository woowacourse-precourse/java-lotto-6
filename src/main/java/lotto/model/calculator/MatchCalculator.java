package lotto.model.calculator;

import static lotto.utils.constants.LottoConstants.MATCH_FIVE_COUNT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.result.MatchResult;
import lotto.domain.result.WinningResult;

public class MatchCalculator {
    public static MatchResult calculateMatches(List<Lotto> lottos, WinningResult winningResult) {
        Map<Integer, Integer> matchCounts = new HashMap<>();
        int bonusMatchCount = 0;

        for (Lotto lotto : lottos) {
            int count = lotto.countMatches(winningResult.getWinningNumbers());
            boolean isBonusMatched = lotto.isBonusMatched(winningResult.getBonusNumber());

            updateMatchCounts(matchCounts, count);

            if (count == MATCH_FIVE_COUNT && isBonusMatched) {
                bonusMatchCount++;
                removeMatchCounts(matchCounts, MATCH_FIVE_COUNT);
            }
        }

        return new MatchResult(matchCounts, bonusMatchCount);
    }

    private static void updateMatchCounts(Map<Integer, Integer> matchCounts, int count) {
        matchCounts.put(count, matchCounts.getOrDefault(count, 0) + 1);
    }

    private static void removeMatchCounts(Map<Integer, Integer> matchCounts, int count) {
        matchCounts.put(count, matchCounts.getOrDefault(count, 0) - 1);
    }
}
