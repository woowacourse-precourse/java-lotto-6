package lotto.domain;

import static lotto.domain.Ranking.*;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    Map<Ranking, Integer> winningStatus = new HashMap<>();

    public WinningStatistics() {
        winningStatus.put(THREE_MATCHES, 0);
        winningStatus.put(FOUR_MATCHES, 0);
        winningStatus.put(FIVE_MATCHES, 0);
        winningStatus.put(FIVE_MATCHES_BOUNS_MATCHES, 0);
        winningStatus.put(SIX_MATCHES, 0);
    }

    private void incrementWinningStatus(int matchCount) {
        winningStatus.keySet().stream()
                .filter(ranking -> ranking.getMatchCount() == matchCount)
                .findAny()
                .ifPresent(ranking -> winningStatus.replace(ranking, winningStatus.get(ranking) + 1));
    }
}
