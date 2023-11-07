package lotto.domain;

public enum Grade {
    FIFTH("3", 3, 5_000),
    FOURTH("4", 4, 50_000),
    THIRD("5", 5, 1_500_000),
    SECOND("5+B", 5, 30_000_000),
    FIRST("6", 6, 2_000_000_000);

    private final String rank;
    private final int matchCount;
    private final int prizeMoney;

    Grade(String rank, int matchCount, int prizeMoney) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public String getRank() {
        return rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
