package lotto.constant;

public enum LottoConstant {
    LOTTO_PRICE(1000),
    ZERO(0),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_COUNT(6);

    private final Integer value;

    LottoConstant(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
