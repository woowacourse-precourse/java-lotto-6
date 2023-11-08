package lotto.configurations;

public enum SettingValues {
    // config values
    MIN_OF_RANGE(1),
    MAX_OF_RANGE(45),
    SIZE_OF_LOTTO(6),
    PRICE_OF_LOTTO(1000),

    // values about rankings
    FIRST(1),
    POINT_OF_FIRST(6),
    REWARD_OF_FIRST(2000000000),
    SECOND(2),
    POINT_OF_SECOND(5),
    REWARD_OF_SECOND(30000000),
    THIRD(3),
    POINT_OF_THIRD(5),
    REWARD_OF_THIRD(1500000),
    FOURTH(4),
    POINT_OF_FOURTH(4),
    REWARD_OF_FOURTH(50000),
    FIFTH(5),
    POINT_OF_FIFTH(3),
    REWARD_OF_FIFTH(5000),
    FAIL(0),
    REWARD_OF_FAIL(0),
    POINT_OF_FAIL(0);

    private final int value;

    SettingValues(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
