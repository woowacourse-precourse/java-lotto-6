package lotto.domain;

public enum Prize {
    FIFTH_PLACE(5_000, 3, false),
    FOURTH_PLACE(50_000, 4, false),
    THIRD_PLACE(1_500_000, 5, false),
    SECOND_PLACE(30_000_000, 5, true),
    FIRST_PLACE(2_000_000_000, 6, false);

    private int money;
    private int matchingNumberCount;
    private boolean isBonusNumberMatched;

    Prize(int money, int matchingNumberCount, boolean isBonusNumberMatched) {
        this.money = money;
        this.matchingNumberCount = matchingNumberCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
    }
}
