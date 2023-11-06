package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoBuyer {
    private final Map<WinningRank, Integer> winCounts;

    public LottoBuyer() {
        winCounts = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            winCounts.put(rank, 0);
        }
    }

    public void addWinCount(WinningRank winningRank) {
        int currentCount = winCounts.get(winningRank);
        winCounts.put(winningRank, currentCount + 1);
    }

    public int getWinCount(WinningRank winningRank) {
        return winCounts.get(winningRank);
    }
}
