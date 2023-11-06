package lotto;

import java.util.HashMap;
import java.util.Map;

public class Calculations {
    private final Map<Integer, WinningRank> winningTable = new HashMap<>();
    private Map<WinningRank, Integer> winningTally = new HashMap<>();

    public Calculations() {
        winningTable.put(1, WinningRank.FIRST_WINNING);
        winningTable.put(2, WinningRank.SECOND_WINNING);
        winningTable.put(3, WinningRank.THIRD_WINNING);
        winningTable.put(4, WinningRank.FOURTH_WINNING);
        winningTable.put(5, WinningRank.FIFTH_WINNING);
        winningTable.put(6, WinningRank.NO_LUCK);
        winningTable.put(7, WinningRank.NO_LUCK);
        winningTable.put(8, WinningRank.NO_LUCK);
        winningTally.put(WinningRank.FIRST_WINNING, 0);
        winningTally.put(WinningRank.SECOND_WINNING, 0);
        winningTally.put(WinningRank.THIRD_WINNING, 0);
        winningTally.put(WinningRank.FOURTH_WINNING, 0);
        winningTally.put(WinningRank.FIFTH_WINNING, 0);
        winningTally.put(WinningRank.NO_LUCK, 0);
    }

    public void tallyWinnings(int winningRank) {
        int existValue = winningTally.get(winningTable.get(winningRank));
        winningTally.put(winningTable.get(winningRank), existValue + 1);
    }

    public Map<WinningRank, Integer> getWinningTally() {
        return winningTally;
    }
}
