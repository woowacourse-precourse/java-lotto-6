package lotto.Model;

public enum Prize {
    NO_RANK(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);
    private final int matchCount;
    private final int reward;

    Prize(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount(){
        return matchCount;
    }
    public int getReward(){
        return reward;
    }
}
