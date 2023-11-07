package lotto.config;

public enum LottoPrize {
    MATCH_0(0),
    MATCH_1(0),
    MATCH_2(0),
    MATCH_3(5000),
    MATCH_4(50000),
    MATCH_5(150000),
    MATCH_5BONUS(30000000),
    MATCH_6(2000000000);

    private final int prizeMoney;

    LottoPrize(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize getPrize(int matchCount, boolean matchBonus) {
        String bonus = Constant.LOTTO_PRIZE_NON_BONUS;
        if (matchBonus) {
            bonus = Constant.LOTTO_PRIZE_BONUS;
        }
        return LottoPrize.valueOf(Constant.LOTTO_PRIZE_NAME + matchCount + bonus);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
