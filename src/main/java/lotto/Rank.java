package lotto;

public enum Rank {
    FIRST_PLACE("2,000,000,000원", 6),
    SECOND_PLACE("30,000,000원", 5.5),
    THIRD_PLACE("1,500,000원", 5),
    FOURTH_PLACE("50,000원", 4),
    FIFTH_PLACE("5,000원", 3),
    NONE("0원", 0)
    ;

    private final String reward;
    private final double matchNumberCount;


    Rank(String reward, double matchNumberCount) {
        this.reward = reward;
        this.matchNumberCount = matchNumberCount;
    }

    public String getReward() {
        return reward;
    }

    public double getMatchNumberCount() {
        return matchNumberCount;
    }
}

