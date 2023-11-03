package lotto.domain.winning;

import java.util.Arrays;

public enum Winning {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    NOTHING(0, 0);

    private final int matchCount;
    private final long winningAmount;

    Winning(int matchCount, long winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static Winning of(int matchCount, boolean bonus) {
        if (matchCount == SECOND_PLACE.matchCount && bonus) {
            return SECOND_PLACE;
        }
        if (matchCount == THIRD_PLACE.matchCount && !bonus) {
            return THIRD_PLACE;
        }
        return Arrays.stream(values())
                .filter(winning -> matchCount == winning.matchCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
