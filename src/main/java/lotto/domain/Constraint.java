package lotto.domain;

public enum Constraint {
    MIN(1),
    MAX(45),
    SIZE(6),
    ;

    private final int value;

    Constraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
