package lotto;

import java.util.Arrays;
import java.util.EnumMap;

public class WinningCounts {
    private final EnumMap<WinningRank, Integer> counts;

    public WinningCounts() {
        counts = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values())
                .forEach(winningRank -> counts.put(winningRank, 0));
    }

    public void incrementCount(WinningRank rank) {
        counts.put(rank, counts.get(rank) + 1);
    }

    public int getCount(WinningRank rank) {
        return counts.get(rank);
    }
}

