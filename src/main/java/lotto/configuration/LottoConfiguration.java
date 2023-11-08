package lotto.configuration;

public enum LottoConfiguration {
    LOTTO_PRICE(1000),
    LOTTO_SIZE(6),
    LOTTO_BOUNDARY_START_NUMBER(1),
    LOTTO_BOUNDARY_END_NUMBER(45);

    private final int value;

    LottoConfiguration(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
