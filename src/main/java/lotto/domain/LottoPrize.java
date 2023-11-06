package lotto.domain;

public enum LottoPrize {
    Three_PRIZE(3, "5,000"),
    FOUR_PRIZE(4,"50,000"),
    FIVE_PRIZE(5,"1,500,000"),
    FIVE_AND_BONUS_PRIZE(50,"30,000,000"),
    SIX_PRIZE(6,"2,000,000,000");

    private final int count;
    private final String prizeMoney;
    LottoPrize(int count, String prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }
}
