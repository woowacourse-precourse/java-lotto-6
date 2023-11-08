package lotto.utils;

public enum GameRules {
    START_RANGE(1),
    END_RANGE(45),
    NUMBERS_SIZE(6),
    MINIMUN_UNIT(1000),
    MINIMUM_WIN_COUNT(3);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
