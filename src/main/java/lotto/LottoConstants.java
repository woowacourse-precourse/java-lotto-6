package lotto;

public enum LottoConstants {
    LOTTO_SIZE(6),
    NUMBER_LOW_BOUND(1),
    NUMBER_HIGH_BOUND(45);

    private final long value;

    LottoConstants(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

}
