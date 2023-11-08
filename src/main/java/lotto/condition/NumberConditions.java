package lotto.condition;

public enum NumberConditions {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_COUNT(6);

    private final int number;

    NumberConditions(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
