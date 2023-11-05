package lotto;

import java.util.EnumMap;
import java.util.Map.Entry;

public enum Rank {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000),
    NONE(0);

    private final long prize;

    Rank(int prize) {
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
}
