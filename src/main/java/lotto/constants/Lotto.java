package lotto.constants;

public enum Lotto {

    SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    COST(1000);

    private final int value;

    Lotto(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
