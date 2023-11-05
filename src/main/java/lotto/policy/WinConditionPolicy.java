package lotto.policy;

public enum WinConditionPolicy {
    FIRST_PLACE(6, 0, 2000000000),
    SECOND_PLACE(5, 1, 30000000),
    THIRD_PLACE(5, 0, 1500000),
    FOURTH_PLACE(4, 0, 50000),
    FIFTH_PLACE(3, 0, 5000);

    private final int winNumberCount;
    private final int bonusNumberCount;
    private final int reward;

    private WinConditionPolicy(int winNumberCount, int bonusNumberCount, int reward) {
        this.winNumberCount = winNumberCount;
        this.bonusNumberCount = bonusNumberCount;
        this.reward = reward;
    }

    public WinConditionPolicy getMatchWith(int winNumberCount, int bonusNumberCount) {
        if (this.winNumberCount == winNumberCount
                && this.bonusNumberCount == bonusNumberCount) {
            return this;
        }
        return null;
    }
}
