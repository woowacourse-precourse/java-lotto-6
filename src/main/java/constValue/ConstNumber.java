package constValue;

public enum ConstNumber {
    LOTTO_PRICE(1000),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);
    final private int value;

    public int getValue() {
        return value;
    }

    private ConstNumber(int value) {
        this.value = value;
    }
}
