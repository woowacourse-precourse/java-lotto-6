package value;

public enum LottoDefaultValue {
    LOTTO_PRICE(1000),
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000),
    LOTTO_VALUE_MIN(1),
    LOTTO_VALUE_MAX(45),
    LOTTO_NUMBER_COUNT(6);

    private final int number;

    LottoDefaultValue(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

