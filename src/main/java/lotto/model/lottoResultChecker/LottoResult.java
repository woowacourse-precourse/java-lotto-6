package lotto.model.lottoResultChecker;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> resultCounts = new HashMap<>();

    public void addResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            incrementCount(5.5);
        }
        incrementCount((double) matchCount);
    }

    private void incrementCount(double key) {
        resultCounts.putIfAbsent((int) key, 0);
        resultCounts.put((int) key, resultCounts.get((int) key) + 1);
    }

    public int getCountForMatch(int matchCount) {
        return resultCounts.getOrDefault(matchCount, 0);
    }

    public int getBonusMatchCount() {
        return resultCounts.getOrDefault(5.5, 0);
    }

}