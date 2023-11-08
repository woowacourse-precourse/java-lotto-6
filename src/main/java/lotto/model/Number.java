package lotto.model;

public enum Number {
    MIN_RANGE(1),
    MAX_RANGE(45),
    EA(6);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
