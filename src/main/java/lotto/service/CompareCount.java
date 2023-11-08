package lotto.service;

public enum CompareCount {
    INITIAL_ZERO_COUNT(0),
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    SIX_MATCH(6);
    private final int count;

    CompareCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
