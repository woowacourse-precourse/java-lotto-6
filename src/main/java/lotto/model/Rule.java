package lotto.model;

public enum Rule {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    DIGITS(6);

    private final int value;

    Rule(int number) {
        this.value = number;
    }

    public int value() {
        return this.value;
    }
}
