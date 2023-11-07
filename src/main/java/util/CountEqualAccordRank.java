package util;

public enum CountEqualAccordRank {
    FIRST_EQUAL_COUNT(6),
    SECOND_EQUAL_COUNT(5),
    THIRD_EQUAL_COUNT(5),
    FOURTH_EQUAL_COUNT(4),
    FIFTH_EQUAL_COUNT(3);

    private final int equalCount;

    CountEqualAccordRank(int equalCount) {
        this.equalCount = equalCount;
    }

    public int get() {
        return equalCount;
    }
}
