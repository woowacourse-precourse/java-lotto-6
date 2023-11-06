package lotto.constant;

public enum LottoGrade {
    SIX_MATCH,
    FIVE_AND_BONUS_MATCH,
    FIVE_MATCH,
    FOUR_MATCH,
    THREE_MATCH,
    NO_GRADE,
    ;

    public static LottoGrade findLottoGrade(int matchNumber, boolean isBonus) {
        if (matchNumber == 6) {
            return SIX_MATCH;
        } else if (matchNumber == 5 && isBonus) {
            return FIVE_AND_BONUS_MATCH;
        } else if (matchNumber == 5 && !isBonus) {
            return FIVE_MATCH;
        } else if (matchNumber == 4) {
            return FOUR_MATCH;
        } else if (matchNumber == 3) {
            return THREE_MATCH;
        }
        return NO_GRADE;
    }
}
