package lotto.model.domain;

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

    public static LottoRank findRank(int correct, boolean hasBonus) {
        if (correct == 6) {
            return FIRST_PLACE;
        }

        if (correct == 5 && hasBonus) {
            return SECOND_PLACE;
        }

        if (correct == 5) {
            return THIRD_PLACE;
        }

        if (correct == 4) {
            return FOURTH_PLACE;
        }

        if (correct == 3) {
            return FIFTH_PLACE;
        }

        return NO_LUCK;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getReward() {
        return reward;
    }
}
