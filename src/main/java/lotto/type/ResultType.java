package lotto.type;

public enum ResultType {
    THIRD(3, false, 5000),
    FOURTH(4, false, 50000),
    FIFTH(5, false, 1500000),
    FIFTH_BONUS(5, true, 30000000),
    ALL(6, false, 2000000000);
    private final int sameNumber;
    private final boolean isBonus;
    private final int reward;

    ResultType(int sameNumber, Boolean isBonus, int reward) {
        this.sameNumber = sameNumber;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    public int sameNumber() {
        return sameNumber;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int reward() {
        return reward;
    }
}
