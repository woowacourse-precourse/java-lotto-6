package lotto.constants;

public enum Value {
    LOTTO_SIZE(6);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
