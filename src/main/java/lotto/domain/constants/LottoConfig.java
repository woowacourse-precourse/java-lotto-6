package lotto.domain.constants;

public enum LottoConfig {
    LOTTO_COUNT(),
    LOTTO_SIZE(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45);

    private int value;

    LottoConfig() {

    }

    LottoConfig(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
