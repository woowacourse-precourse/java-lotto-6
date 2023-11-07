package lotto.domain;

import static lotto.domain.Ranking.*;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    Map<Ranking, Integer> winningStatus = new HashMap<>();
    Ranking ranking;

    public WinningStatistics() {
        winningStatus.put(THREE_MATCHES, 0);
        winningStatus.put(FOUR_MATCHES, 0);
        winningStatus.put(FIVE_MATCHES, 0);
        winningStatus.put(FIVE_MATCHES_BONUS_MATCHES, 0);
        winningStatus.put(SIX_MATCHES, 0);
    }

    public void incrementWinningStatus(int matchCount) {
        winningStatus.computeIfPresent(
                Ranking.findByMatchCount(matchCount),
                (ranking, count) -> count + 1
        );
    }
}
