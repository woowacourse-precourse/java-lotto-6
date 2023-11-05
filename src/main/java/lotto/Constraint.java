package lotto;

enum Constraint {
    MIN(1),
    MAX(45),
    ;

    private final int value;

    Constraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
