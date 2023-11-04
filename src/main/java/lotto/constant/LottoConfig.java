package lotto.constant;

public enum LottoConfig {
    TICKET_PRICE(1000);
    private final Integer value;

    LottoConfig(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
