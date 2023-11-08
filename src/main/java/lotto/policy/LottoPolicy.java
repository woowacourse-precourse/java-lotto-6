package lotto.policy;

public enum LottoPolicy {
    LOTTO_AMOUNT(1000),
    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final int value;

    LottoPolicy(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
