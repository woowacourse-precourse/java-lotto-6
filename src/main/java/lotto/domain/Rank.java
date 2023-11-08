package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int prize;

    Rank(int matchCount, boolean hasBonusNumber, int prize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getCountOfMatch() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return hasBonusNumber;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == countOfMatch)
                .filter(rank -> !rank.hasBonusNumber || matchBonus)
                .findFirst()
                .orElse(MISS);
    }

    public static final Comparator<Rank> PRIZE_ASCENDING_ORDER = Comparator.comparingInt(o -> o.prize);

}