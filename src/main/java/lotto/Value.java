package lotto;

public enum Value {
    RAINGE_MIN(1),
    RAINGE_MAX(45),
    LOTTO_NUMBER(6),
    ZERO(0),
    ONE(1),
    IS_EMPTY(0),
    LOTTO_PRICE(1000);

    private final int number;

    Value(int number) {
        this.number = number;
    }

    public int get() {
        return this.number;
    }
}
