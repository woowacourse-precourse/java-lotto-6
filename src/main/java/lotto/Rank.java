package lotto;

public enum Rank {
    FIRST_PLACE("2,000,000,000원"),
    SECOND_PLACE("30,000,000원"),
    THIRD_PLACE("1,500,000원"),
    FOURTH_PLACE("50,000원"),
    FIFTH_PLACE("5,000원")
    ;

    private final String reward;

    Rank(String reward) {
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }
}

