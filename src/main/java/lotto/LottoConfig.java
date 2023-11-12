package lotto;

public enum LottoConfig {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    TOTAL_LOTTO_NUMBER(6),
    PURCHASING_UNIT(1000),
    BONUS_POSITION(6);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
