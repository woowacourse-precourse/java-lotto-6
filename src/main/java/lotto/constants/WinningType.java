package lotto.constants;

public enum WinningType {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000);

    private Integer count;
    private Integer bonusCount;
    private Integer amount;

    WinningType(Integer count, Integer bonusCount, Integer amount) {
        this.count = count;
        this.bonusCount = bonusCount;
        this.amount = amount;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getBonusCount() {
        return bonusCount;
    }

    public Integer getAmount() {
        return amount;
    }
}
