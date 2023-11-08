package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum WinningDetails {
    FIFTH(3, 5_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 3),
    FOURTH(4, 50_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 4),
    THIRD(5, 1_500_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 5 && !isBonusNumberMatch),
    SECOND(5, 30_000_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 5 && isBonusNumberMatch),
    FIRST(6, 2_000_000_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 6),
    MISS(0, 0,
            (matchCount, isBonusNumberMatch) -> matchCount < 3);

    private int countOfSameNumber;
    private long prize;
    private BiPredicate<Integer, Boolean> rankDeterminer;

    WinningDetails (int countOfSameNumber, long prize, BiPredicate<Integer, Boolean> rankDeterminer) {
        this.countOfSameNumber = countOfSameNumber;
        this.prize = prize;
        this.rankDeterminer = rankDeterminer;
    }

    public static WinningDetails getRank(final int matchCount, Boolean containBonusNumber) {
        return Arrays.stream(WinningDetails.values())
                .filter(rank -> rank.rankDeterminer.test(matchCount, containBonusNumber))
                .findAny()
                .orElse(MISS);
    }

    public int getCount() {
        return countOfSameNumber;
    }

    public long getPrize() {
        return prize;
    }
}
