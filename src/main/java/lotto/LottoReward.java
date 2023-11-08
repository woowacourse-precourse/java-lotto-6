package lotto;


import java.util.Arrays;

public enum LottoReward {
    FIRST_PRIZE(6, 2_000_000_000L),
    SECOND_PRIZE(5, 30_000_000L),
    THIRD_PRIZE(5, 1_500_000L),
    FOURTH_PRIZE(4, 50_000L),
    FIFTH_PRIZE(3, 5_000L),
    NOTHING(0, 0);

    private final int matchNumbersCount;
    private final long winningReward;
    private static final int WINNING_MIN_COUNT = 3;

    LottoReward(int matchNumbersCount, long winningReward) {
        this.matchNumbersCount = matchNumbersCount;
        this.winningReward = winningReward;
    }

}
