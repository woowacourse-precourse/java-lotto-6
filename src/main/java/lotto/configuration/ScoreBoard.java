package lotto.configuration;

public enum ScoreBoard {
    FIRST("1st", 0L),
    SECOND("2nd", 0L),
    THIRD("3rd", 0L),
    FOURTH("4th", 0L),
    FIFTH("5th", 0L),
    SIXTH("6th", 0L),
    SEVENTH("7th", 0L),
    EIGHTH("8th", 0L);

    private final String key;
    private final long value;

    ScoreBoard(String key, long value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }
}

