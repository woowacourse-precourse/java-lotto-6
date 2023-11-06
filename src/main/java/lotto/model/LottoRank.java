package lotto.model;

public enum LottoRank {
    NO_LUCK(0, false, 0),
    FIFTH_PLACE(3, false, 5000),
    FOURTH_PLACE(4, false, 50000),
    THIRD_PLACE(5, false, 1500000),
    SECOND_PLACE(5, true, 30000000),
    FIRST_PLACE(6, false, 2000000000);

    private final int correctCount;
    private final boolean bonus;
    private final int reward;

    LottoRank(int correctCount, boolean hasBonus, int reward) {
        this.correctCount = correctCount;
        this.bonus = hasBonus;
        this.reward = reward;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean hasBonus() {
        return bonus;
    }

    public int getReward() {
        return reward;
    }
}
