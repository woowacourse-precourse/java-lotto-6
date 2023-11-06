package lotto.constant;

public enum LottoConstant {
    LOTTO_PRICE(1000),
    ZERO(0);

    private final Integer value;

    LottoConstant(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
