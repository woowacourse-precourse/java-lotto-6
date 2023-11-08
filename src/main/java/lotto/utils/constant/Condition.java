package lotto.utils.constant;

public enum Condition {
    MIN_RANGE(1),
    MAX_RANGE(45),
    SIZE(6);

    private final int number;

    Condition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
