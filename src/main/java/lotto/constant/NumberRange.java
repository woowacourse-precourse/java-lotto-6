package lotto.constant;

public enum NumberRange {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    ;

    private final int number;

    NumberRange(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
