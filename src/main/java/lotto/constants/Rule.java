package lotto.constants;

public enum Rule {
    MIN_MONEY(1000);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
