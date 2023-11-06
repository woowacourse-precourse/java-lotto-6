package lotto.domain.constants;

public enum LottoRule {

    PRICE(1000),
    LOTTO_SIZE(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
