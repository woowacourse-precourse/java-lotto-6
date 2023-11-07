package constValue;

public enum ConstNumber {
    LOTTO_PRICE(1000),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    FIRST_GRADE(1),
    SECOND_GRADE(2),
    THIRD_GRADE(3),
    FOURTH_GRADE(4),
    FIFTH_GRADE(5),
    LOSE(0),
    RESULT_ARRAY_SIZE(5);
    final private int value;

    public int getValue() {
        return value;
    }

    private ConstNumber(int value) {
        this.value = value;
    }
}
