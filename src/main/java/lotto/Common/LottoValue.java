package lotto.Common;

public enum LottoValue {
    LOTTO_COUNT_NUMBER(6),
    LOTTO_ONE_TICKET_PRICE(1000),
    LOTTO_FIRST_NUMBER(1),
    LOTTO_FINAL_NUMBER(45);

    private final Integer value;
    LottoValue(Integer value) {
        this.value = value;

    }

    public Integer getValue() {
        return value;
    }
}
