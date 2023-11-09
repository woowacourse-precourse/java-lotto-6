package lotto.domain.ticket;

public enum LottoNumberConfig {
    MINIMUM_RANGE(1),
    MAXIMUM_RANGE(45),
    NUMBER_COUNT(6);
    private final int value;

    LottoNumberConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
