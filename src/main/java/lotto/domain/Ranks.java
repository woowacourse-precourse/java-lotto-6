package lotto.domain;

public enum Ranks {
    ZERO_RANE(0, 0L, "0"),
    ONE_MATCH(0, 0L, "0"),
    TWO_MATCH(0, 0L, "0"),
    THREE_MATCH(3, 5000L, "5,000"),
    FOUR_MATCH(4, 50000L, "50,000"),
    FIVE_MATCH(5, 1500000L, "1,500,000"),
    SIX_MATCH(6, 2000000000L, "2,000,000,000"),
    FIVE_MATCH_BONUS(5, 30000000L, "30,000,000");

    final private int count;
    final private long prize;
    final private String separatePrize;

    Ranks(int count, long prize, String separatePrize) {
        this.count = count;
        this.prize = prize;
        this.separatePrize = separatePrize;
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }

    public String getSeparatePrize() {
        return separatePrize;
    }
}
