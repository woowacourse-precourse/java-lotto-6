package lotto.utils;

public enum CalculationConstants {
    MINUS_ONE(1),
    MINUS_TWO(2),
    REMAINS(0),
    COMMAS_NUMBERS(5),
    START_COUNT(0),
    ZERO(0),
    PERCENT_CALCULATION(100),
    ONE(1);

    private final Integer value;

    CalculationConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
