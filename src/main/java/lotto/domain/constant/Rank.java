package lotto.domain.constant;

public enum Rank {

    FIRST("6개 일치 (2,000,000,000원)", 6, false, 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, true, 30000000),
    THIRD("5개 일치 (1,500,000원)", 5, false, 15000000),
    FORTH("4개 일치 (50,000원)", 4, null, 50000),
    FIFTH("3개 일치 (5,000원)", 3, null, 5000);

    private final String description;
    private final int sameCount;
    private final Boolean existBonus;
    private final int reward;

    Rank(String description, int sameCount, Boolean existBonus, int reward) {
        this.description = description;
        this.sameCount = sameCount;
        this.existBonus = existBonus;
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public int getSameCount() {
        return sameCount;
    }

    public Boolean getExistBonus() {
        return existBonus;
    }

    public int getReward() {
        return reward;
    }
}
