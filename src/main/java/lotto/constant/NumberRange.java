package lotto.Enum;

public enum RangeNumber {
    LOWEST_NUMBER(1),
    HIGHEST_NUMBER(45);

    private final int number;
    RangeNumber(int number) {
        this.number = number;
    }
    public int getRangeNumber() {
        return number;
    }
}
