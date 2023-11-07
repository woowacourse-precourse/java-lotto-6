package lotto.domain;

public enum LottoSetting {
    NUMBER_RANGE_START(1), // inclusive
    NUMBER_RANGE_END(45), // inclusive
    NUMBER_COUNT(6),
    PRICE(1000),
    WINNING_TYPE_COUNT(5);

    private final int value;

    LottoSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
