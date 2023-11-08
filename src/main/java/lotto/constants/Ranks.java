package lotto.constants;

public enum Ranks {
    ZERO_RANE(0, 0L, "0"),
    ONE_MATCH(0, 0L, "0"),
    TWO_MATCH(0, 0L, "0"),
    THREE_MATCH(3, 5000L, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 50000L, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 1500000L, "5개 일치 (1,500,000원)"),
    SIX_MATCH(6, 2000000000L, "6개 일치 (2,000,000,000원)"),
    FIVE_MATCH_BONUS(5, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)");

    private final int count;
    private final long prize;
    private final String presentPrize;

    Ranks(int count, long prize, String presentPrize) {
        this.count = count;
        this.prize = prize;
        this.presentPrize = presentPrize;
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }

    public String getPresentPrize() {
        return presentPrize;
    }
}
