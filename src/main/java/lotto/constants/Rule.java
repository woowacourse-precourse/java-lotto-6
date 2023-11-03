package lotto.constants;

public enum Rule {
    MIN_MONEY(1000),
    MIN_LOTTO(1),
    MAX_LOTTO(45),
    LOTTO_SIZE(6);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
