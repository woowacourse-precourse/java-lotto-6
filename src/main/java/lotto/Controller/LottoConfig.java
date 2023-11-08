package lotto.Controller;

public enum LottoConfig {
    NUMBER_RANGE_START(1),
    NUMBER_RANGE_END(45),
    NUMBERS_PER_TICKET(6);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}