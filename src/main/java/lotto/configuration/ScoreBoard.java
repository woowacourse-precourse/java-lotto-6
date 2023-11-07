package lotto.configuration;

public enum ScoreBoard {
    FIRST(1, 0L),
    SECOND(2, 0L),
    THIRD(3, 0L),
    FOURTH(4, 0L),
    FIFTH(5, 0L),
    SIXTH(6, 0L),
    SEVENTH(7, 0L),
    EIGHTH(8, 0L);

    private final long key;
    private final long value;

    ScoreBoard(long key, long value) {
        this.key = key;
        this.value = value;
    }

    public long getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }
}

