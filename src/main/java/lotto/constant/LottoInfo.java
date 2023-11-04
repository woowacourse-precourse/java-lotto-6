package lotto.constant;

public enum LottoInfo {

    ONE_LOTTO_PRICE(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_SIZE(6);

    private Integer value;

    LottoInfo(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
