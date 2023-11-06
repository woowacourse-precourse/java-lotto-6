package lotto.domain;

import java.util.Arrays;

public enum WinningRecord {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000),
    NONE(0, 0);

    private final int matchNumber;
    private final int prize;

    WinningRecord(int matchNumber, int prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningRecord getPlaceType(int matchNumbers, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isInRank(rank, matchNumbers, matchBonus))
                .findAny().orElse(NONE);
    }

    private boolean isInRank(WinningRecord rank, int matchNumbers, boolean matchBonus) {
        if ((rank == SECOND_PLACE && matchBonus)
                || (rank == THIRD_PLACE && !matchBonus)
                || (rank != SECOND_PLACE && rank != THIRD_PLACE)) {
            return isMatch(rank.matchNumber, matchNumbers);
        }
        return false;
    }

    private boolean isMatch(int rankMatchNumber, int matchNumbers) {
        return rankMatchNumber == matchNumbers;
    }
}
