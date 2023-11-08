package lotto.model;

public enum Rank {

    FIRST("6개 일치", 6, "2,000,000,000", 2_000_000_000, false),
    SECOND("5개 일치, 보너스 볼 일치", 5, "30,000,000", 30_000_000, true),
    THIRD("5개 일치", 5, "1,500,000", 1_500_000, false),
    FOURTH("4개 일치", 4, "50,000", 50_000, false),
    FIFTH("3개 일치", 3, "5,000", 5_000, false),
    NONE("낙첨", 0, "0", 0, false);


    private final String description;
    private final int matchCount;
    private final String prize;
    private final int reward;
    private final Boolean bonusMath;


    Rank(String description, int matchCount, String prize, int reward, Boolean bonusMath) {
        this.description = description;
        this.matchCount = matchCount;
        this.prize = prize;
        this.reward = reward;
        this.bonusMath = bonusMath;
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
