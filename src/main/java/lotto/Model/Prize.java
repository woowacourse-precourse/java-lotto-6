package lotto.Model;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NO_RANK(0, 0);
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
