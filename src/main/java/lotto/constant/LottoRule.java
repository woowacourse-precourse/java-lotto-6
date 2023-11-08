package lotto.constant;

public enum LottoRule {
    NUM_OF_NUMBER(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoRule(final int value) {
        this.value = value;
    }

    public int toValue() {
        return this.value;
    }
}
