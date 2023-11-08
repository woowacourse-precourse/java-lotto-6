package lotto.model.constant;

public enum LottoPrizeConstant {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int standard;
    private final long prize;

    LottoPrizeConstant(int standard, long money) {
        this.standard = standard;
        this.prize = money;
    }

    public int getStandard() {
        return standard;
    }

    public long getPrize() {
        return prize;
    }
}
