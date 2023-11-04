package lotto.model;

import java.util.List;

public enum LottoPrize {

    FIRST_PRIZE(2_000_000_000),
    SECOND_PRIZE(30_000_000),
    THIRD_PRIZE(1_500_000),
    FOURTH_PRIZE(50_000),
    FIFTH_PRIZE(5_000);

    private final int prize;

    LottoPrize(final int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static long calculateWinningPrize(final LottoPrize lottoPrize, final long count) {
        return lottoPrize.getPrize() * count;
    }
}
