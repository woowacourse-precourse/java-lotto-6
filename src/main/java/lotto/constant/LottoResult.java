package lotto.constant;

public enum LottoResult {
    THREE_COUNT(3, 5_000),
    FOUR_COUNT(4, 50_000),
    FIVE_COUNT(5, 1_500_000),
    FIVE_COUNT_WITH_BONUS(50,
            30_000_000),
    SIX_COUNT(6, 2_000_000_000);

    private final int prizeCount;

    private final int prizeMoney;

    LottoResult(int number, int price) {
        this.prizeCount = number;
        this.prizeMoney = price;
    }

    public int getPrizeCount() {
        return prizeCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
