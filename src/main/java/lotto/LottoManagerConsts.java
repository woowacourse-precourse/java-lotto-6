package lotto;

public enum LottoManagerConsts {
    THREE(3),
    FOUR(4),
    FIVE(5),
    FIVE_AND_BONUS(6),
    SIX(7),
    REQUIRED_NUMBER_COUNT(6),
    REQUIRED_BONUS_NUMBER_COUNT(1),
    FIRST_GRADE_KEY(7),
    SECOND_GRADE_KEY(6),
    FIRST_MATCH_COUNT(6),
    THIRD_MATCH_COUNT(5),
    MIN_CORRECT_COUNT(3),
    FIRST_GRADE_MONEY(2000000000),
    SECOND_GRADE_MONEY(30000000),
    THIRD_GRADE_MONEY(1500000),
    FORTH_GRADE_MONEY(50000),
    FIFTH_GRADE_MONEY(5000);

    private final int constType;

    LottoManagerConsts(int type) {
        this.constType = type;
    }

    public int getConst() {
        return constType;
    }
};
