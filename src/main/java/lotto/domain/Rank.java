package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private static final List<Rank> VALUES = List.of(values());

    private final int matchCount;
    private final boolean matchBonus;
    private final long prizeMoney;

    Rank(final int matchCount, final boolean matchBonus, final long prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Rank determineRank(final Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.matchCount(winningLotto.getLotto());
        return VALUES.stream()
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> !rank.matchBonus || lotto.contains(winningLotto.getBonusBall()))
                .findFirst()
                .orElse(Rank.NONE);
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
