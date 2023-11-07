package lotto.type;

public enum ResultType {
    THIRD(5000),
    FOURTH(50000),
    FIFTH(1500000),
    FIFTH_BONUS(30000000),
    ALL(2000000000);

    private final int reward;

    ResultType(int reward) {
        this.reward = reward;
    }

    public int reward() {
        return reward;
    }
}
