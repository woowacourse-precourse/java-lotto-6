package lotto.configuration;

public enum ScoreBoard {
    FIRST("1st", 0L),
    SECOND("2nd", 0L),
    THIRD("3rd", 0L),
    FOURTH("4th", 0L),
    FIFTH("5th", 0L);

    private final String key;
    private final Long value;

    ScoreBoard(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }
}

