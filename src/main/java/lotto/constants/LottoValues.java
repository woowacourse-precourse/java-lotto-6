package lotto.constants;

public enum LottoValues {
    RANGE_MIN(1),
    RANGE_MAX(45),
    NUMBERS_COUNT(6),
    AMOUNT_UNIT(1000);

    private Integer value;

    LottoValues(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getPlusValue(Integer plusValue) {
        return value + plusValue;
    }
}
