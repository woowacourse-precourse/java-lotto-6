package lotto.constant;

public enum Value {
    START_NUMBER(1),
    END_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    THOUSAND(1000),
    ZERO(0),
    ONE(1),
    HUNDRED(100);

    private final int number;

    Value(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}