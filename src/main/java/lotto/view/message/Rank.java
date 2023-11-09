package lotto.view.message;

public enum Rank {
    FIFTH(4, "3개 일치 (5,000원)", 5_000L),
    FOURTH(3, "4개 일치 (50,000원)", 50_000L),
    THIRD(2, "5개 일치 (1,500,000원)", 1_500_000L),
    SECOND(1, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000L),
    FIRST(0, "6개 일치 (2,000,000,000원)", 2_000_000_000L);

    private final int index;
    private final String description;
    private final long prize;

    Rank(int index, String description, long prize) {
        this.index = index;
        this.description = description;
        this.prize = prize;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    public long getPrize() {
        return prize;
    }
}