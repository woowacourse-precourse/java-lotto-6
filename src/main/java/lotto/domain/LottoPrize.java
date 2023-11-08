package lotto.domain;

public enum LottoPrize {
    BLANK(0),
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    final private long prize;

    LottoPrize(long prize) {
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }
}
