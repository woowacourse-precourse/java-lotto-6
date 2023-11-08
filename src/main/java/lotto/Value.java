package lotto;

public enum Value {
    RAINGE_MIN(1),
    RAINGE_MAX(45),
    LOTTO_NUMBER(6),
    ZERO(0),
    ONE(1),
    IS_EMPTY(0),
    LOTTO_PRICE(1000),
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    private final int number;

    Value(int number) {
        this.number = number;
    }

    public int get() {
        return this.number;
    }
}
