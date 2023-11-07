package lotto.domain;

import static lotto.domain.Ranking.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningStatistics {
    Map<Ranking, Integer> winningStatus = new LinkedHashMap<>();

    public WinningStatistics() {
        winningStatus.put(THREE_MATCHES, 0);
        winningStatus.put(FOUR_MATCHES, 0);
        winningStatus.put(FIVE_MATCHES, 0);
        winningStatus.put(FIVE_MATCHES_BONUS_MATCHES, 0);
        winningStatus.put(SIX_MATCHES, 0);
    }

    public Map<Ranking, Integer> getWinningStatus() {
        return winningStatus;
    }

    public void incrementWinningStatus(Ranking ranking) {
        winningStatus.replace(ranking, winningStatus.get(ranking) + 1);
    }
}
