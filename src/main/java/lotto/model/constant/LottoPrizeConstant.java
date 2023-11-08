package lotto.model.constant;

public enum LottoPrizeConstant {

    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private final long money;

    LottoPrizeConstant(long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }
}
