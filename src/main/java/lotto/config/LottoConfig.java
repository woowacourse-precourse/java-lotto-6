package lotto.config;

public enum LottoConfig {
    LOTTO_UNIT_PRICE(1000),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45);

    private final int number;

    LottoConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
