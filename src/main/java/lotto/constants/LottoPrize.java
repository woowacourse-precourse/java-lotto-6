package lotto.constants;

public enum LottoPrize {
    PRIZE_FOR_3_MATCHES(5000),
    PRIZE_FOR_4_MATCHES(50000),
    PRIZE_FOR_5_MATCHES(1500000),
    PRIZE_FOR_5_AND_BONUS_MATCHES(30000000),
    PRIZE_FOR_6_MATCHES(2000000000);

    private final long prize;

    LottoPrize(long prize) {
        this.prize = prize;
    }

    public long getPrizeMoney() {
        return prize;
    }
}

