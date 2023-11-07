package lotto.enumeration;

import java.util.Arrays;

public enum WinningType {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);
    private int matchedCount;
    private int prize;

    WinningType(int matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public static WinningType compare(int count, boolean hasBonusNum) {
        if (hasBonusNum && count == 5) {
            return WinningType.SECOND;
        }
        if (count < FIFTH.getMatchedCount() && !hasBonusNum) {
            return WinningType.MISS;
        }
        return Arrays.stream(values())
                .filter(winningType -> winningType.matchedCount == count)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
