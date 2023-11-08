package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<String, Integer> winningResults;

    public WinningResult() {
        this.winningResults = new HashMap<>();
        initializeResults();
    }

    public void initializeResults() {
        winningResults.put("3", 0);
        winningResults.put("4", 0);
        winningResults.put("5", 0);
        winningResults.put("5_bonus", 0);
        winningResults.put("6", 0);

    }

    public void increaseWinningCount(int matchCount, boolean isMatchBonus) {
        if (winningResults.containsKey(String.valueOf(matchCount)) || (matchCount == 5 && isMatchBonus)) {
            String key = String.valueOf(matchCount);
            if (matchCount == 5 && isMatchBonus) {
                key += "_bonus";
            }
            winningResults.put(key, winningResults.get(key) + 1);
        }
    }

    public Map<String, Integer> displayWinningResults() {
        return winningResults;
    }
}
