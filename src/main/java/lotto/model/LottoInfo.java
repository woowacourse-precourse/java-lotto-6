package lotto.model;

public class LottoInfo {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int NUMBER_COUNT = 6;
    public static final int RANK_COUNT = 6;

    public enum Prize{
        PRIZE_0ST(0),
        PRIZE_1ST(2_000_000_000),
        PRIZE_2ST(30_000_000),
        PRIZE_3ST(1_500_000),
        PRIZE_4ST(50_000),
        PRIZE_5ST(5_000),
        ;

        final int money;

        Prize(int money) {
            this.money=money;
        }
    }
}
