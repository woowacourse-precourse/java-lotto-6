package lotto.domain;

import java.util.EnumMap;
import java.util.Map.Entry;

public enum Rank {
    FIFTH(3, false, 5_000L),
    FOURTH(4, false, 50_000L),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L),
    NONE(0, false, 0L);

    private final int matchCount;
    private final boolean hasBonus;
    private final long prize;

    Rank(int matchCount, boolean hasBonus, long prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank of(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = lotto.match(winningNumber.getWinningLotto());
        boolean hasBonusNumber = lotto.has(winningNumber.getBonusNumber());
        return Rank.of(matchCount, hasBonusNumber);
    }

    private static Rank of(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 3) {
            return Rank.FIFTH;
        }
        if (matchCount == 4) {
            return Rank.FOURTH;
        }
        if (matchCount == 5 && !hasBonusNumber) {
            return Rank.THIRD;
        }
        if (matchCount == 5) {
            return Rank.SECOND;
        }
        if (matchCount == 6) {
            return Rank.FIRST;
        }
        return NONE;
    }

    public static long getTotalPrize(EnumMap<Rank, Integer> rankToCount) {
        long totalPrize = 0;
        for (Entry<Rank, Integer> rankToCountEntry : rankToCount.entrySet()) {
            totalPrize += rankToCountEntry.getKey().prize * rankToCountEntry.getValue();
        }
        return totalPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public long getPrize() {
        return prize;
    }
}
