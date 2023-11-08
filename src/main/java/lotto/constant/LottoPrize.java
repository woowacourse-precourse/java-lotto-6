package lotto.constant;

public enum LottoPrize {
    Three_PRIZE(3, 5000),
    FOUR_PRIZE(4,50000),
    FIVE_PRIZE(5,1500000),
    FIVE_AND_BONUS_PRIZE(50,30000000),
    SIX_PRIZE(6,2000000000);

    private final int count;
    private final long prizeMoney;
    LottoPrize(int count, long prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public static Long findPrizeMoney(int number) {
        for (LottoPrize prize : values()) {
            if (prize.count == number) {
                return prize.prizeMoney;
            }
        }
        return 0l;
    }
}
