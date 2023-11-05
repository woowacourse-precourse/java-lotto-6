package lotto.constant;

public enum StateType {
    THREE_MATCH, FOUR_MATCH, FIVE_MATCH_NO_BONUS, FIVE_MATCH_BONUS, SIX_MATCH, UNDEFINED, NO_PRIZE;

    public static StateType valueOf(int correctCount, boolean correctBonus) {
        if (correctCount == 3) {
            return THREE_MATCH;
        }

        if (correctCount == 4) {
            return FOUR_MATCH;
        }

        if (correctCount == 5 && !correctBonus) {
            return FIVE_MATCH_NO_BONUS;
        }

        if (correctCount == 5) {
            return FIVE_MATCH_BONUS;
        }

        if (correctCount == 6) {
            return SIX_MATCH;
        }

        return NO_PRIZE;
    }
}
