package calculate;

public enum MatchNumber {
    FIRST(6, "6개 일치 (2,000,000,000원)", 2000000000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD(5, "5개 일치 (1,500,000원)", 1500000),
    FOURTH(4, "4개 일치 (50,000원)", 50000),
    FIFTH(3, "3개 일치 (5,000원)", 5000);

    private final int matchingCount;
    private final String description;
    private final int prize;

    MatchNumber(int matchingCount, String description, int prize) {
        this.matchingCount = matchingCount;
        this.description = description;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }
}