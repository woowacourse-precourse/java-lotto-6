package domain.LottoGame;

import java.util.Map;

public class LottoGameResult {
    private final Map<Integer, Long> matchCounts;

    public LottoGameResult(Map<Integer, Long> matchCounts) {
        this.matchCounts = matchCounts;
    }

    public void updateResult(int matchCount) {
        matchCounts.put(matchCount, matchCounts.getOrDefault(matchCount, 0L) + 1);
    }

    public Map<Integer, Long> getMatchCounts() {
        return matchCounts;
    }
}
