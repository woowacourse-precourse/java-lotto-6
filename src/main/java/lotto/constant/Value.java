package lotto.constant;

public enum Value {
    THOUSAND(1000),
    ZERO(0);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}