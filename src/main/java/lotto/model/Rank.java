package lotto.model;

public enum Rank {
    FIRST("6개 일치", 6, "2,000,000,000", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 5, "30,000,000", 30_000_000),
    THIRD("5개 일치", 5, "1,500,000", 1_500_000),
    FOURTH("4개 일치", 4, "50,000", 50_000),
    FIFTH("3개 일치", 3, "5,000", 5_000),
    NONE("낙첨", 0, "0", 0);

    private final String description;
    private final int matchCount;
    private final String prize;
    private final int reward;

    Rank(String description, int matchCount, String prize, int reward) {
        this.description = description;
        this.matchCount = matchCount;
        this.prize = prize;
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public String getPrize() {
        return prize;
    }

    public int getReward() {
        return reward;
    }
}
