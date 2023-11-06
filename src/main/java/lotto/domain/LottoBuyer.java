package lotto.domain;

import static lotto.message.MessageConstants.ONE;
import static lotto.message.MessageConstants.ZERO;

import java.util.HashMap;
import java.util.Map;

public class LottoBuyer {
    private final Map<WinningRank, Integer> winCounts;

    public LottoBuyer() {
        winCounts = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            winCounts.put(rank, ZERO);
        }
    }

    public void addWinCount(WinningRank winningRank) {
        int currentCount = winCounts.get(winningRank);
        winCounts.put(winningRank, currentCount + ONE);
    }

    public int getWinCount(WinningRank winningRank) {
        return winCounts.get(winningRank);
    }
    
}
