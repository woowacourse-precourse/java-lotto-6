package lotto.constant;

public enum NumberRange {
    MIN(1),
    MAX(45);

    private int number;

    private NumberRange(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
