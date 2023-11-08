package lotto.enums;

public enum UtilNumber {
    LOTTO_LENGTH(6),
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5),
    FIRST_CORRECT_CONDITION(6), SECOND_CORRECT_CONDITION(5), THIRD_CORRECT_CONDITION(5), FOURTH_CORRECT_CONDITION(4), FIFTH_CORRECT_CONDITION(3),
    FIRST_REWORD(2000000000), SECOND_REWORD(30000000), THIRD_REWORD(1500000), FOURTH_REWORD(50000), FIFTH_REWORD(5000),

    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1),

    LOTTO_COST(1000);

    private final int utilNumber;

    UtilNumber(int utilNumber) {
        this.utilNumber = utilNumber;
    }

    public int getNumber() {
        return utilNumber;
    }
}
