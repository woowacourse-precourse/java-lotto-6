package lotto.domain;

public enum LottoPrize {
    Three_PRIZE(3, 5000,"5,000"),
    FOUR_PRIZE(4,50000,"50,000"),
    FIVE_PRIZE(5,1500000,"1,500,000"),
    FIVE_AND_BONUS_PRIZE(50,30000000,"30,000,000"),
    SIX_PRIZE(6,2000000000,"2,000,000,000");

    private final int count;
    private final long prizeMoney;
    private final String money;
    LottoPrize(int count, long prizeMoney, String money) {
        this.count = count;
        this.prizeMoney = prizeMoney;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getMoney() {
        return money;
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
