package util;

public enum EqualNumberAccordRank {
    FIRST_EQUAL_NUMBER(6),
    SECOND_EQUAL_NUMBER(5),
    THIRD_EQUAL_NUMBER(5),
    FORTH_EQUAL_NUMBER(4),
    FIFTH_EQUAL_NUMBER(3);

    private final int equalNumber;

    EqualNumberAccordRank(int equalNumber) {
        this.equalNumber = equalNumber;
    }

    public int get() {
        return equalNumber;
    }
}
