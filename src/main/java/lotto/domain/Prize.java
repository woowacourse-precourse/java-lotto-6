package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_LUCK(0, 0);

    private final int matches;
    private final int winnings;

    Prize(int match, int winnings) {
        this.matches = match;
        this.winnings = winnings;
    }

    public static Prize of(final int matches, final boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(prize -> prize.check(matches, hasBonusNumber))
                .findAny()
                .orElse(NO_LUCK);
    }

    boolean check(int matches, boolean hasBonusNumber) {
        return this.matches == matches;
    }

    public int getMatches() {
        return matches;
    }

    public int getWinnings() {
        return winnings;
    }
}
