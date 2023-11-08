package lotto.domain;

public enum Rank {
    FIFTH(3, "3개 일치 (5,000원)", 5_000),
    FOURTH(4, "4개 일치 (50,000원)", 50_000),
    THIRD(5, "5개 일치 (1,500,000원)", 1_500_000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST(6, "6개 일치 (2,000,000,000원)", 2_000_000_000),
    NONE(0, "꽝", 0);

    private final int matchCount;
    private final String description;
    private final int prize;

    Rank(int matchCount, String description, int prize) {
        this.matchCount = matchCount;
        this.description = description;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }
}