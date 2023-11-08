package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0),
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

    private final int matchNumber;
    private final long prize;

    Rank(int matchNumber, long prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank getRank(int match, boolean hasBonusNumber) {
        if (match == SECOND_PLACE.getMatchNumber() && hasBonusNumber)
            return SECOND_PLACE;
        return Arrays.stream(values())
                .filter(rank -> rank.matchNumber == match)
                .findFirst()
                .orElse(NONE);
    }
}
