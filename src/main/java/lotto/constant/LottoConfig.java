package lotto.constant;

public enum LottoConfig {
    TICKET_PRICE(1000),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_COUNT_NUMBER(6);
    private final Integer value;

    LottoConfig(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
