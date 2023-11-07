package lotto.constant;

public enum MatchCriteria {
    FIRST_PLACE(6),
    SECOND_AND_THIRD_PLACE(5),
    FOURTH_PLACE(4),
    FIFTH_PLACE(3);

    private final int count;

    MatchCriteria(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
