package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    private final int matched;
    private final long winningMoney;

    Rank(int matched, long winningMoney) {
        this.matched = matched;
        this.winningMoney = winningMoney;
    }

    public static Rank Of(int matched, boolean matchedBonus) {
        if (matched == SECOND.matched) {
            if (matchedBonus)
                return SECOND;
            return THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matched == matched)
                .findAny()
                .orElse(MISS);
    }

    public int getMatched() {
        return matched;
    }

    public long prize() {
        return winningMoney;
    }
}
