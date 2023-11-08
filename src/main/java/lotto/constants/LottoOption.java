package lotto.constants;

public enum LottoOption {
    LOTTO_TICKET_PRICE(1000),
    START_LOTTO_NUMBER(1),
    END_LOTTO_NUMBER(45),
    LOTTO_COUNT(6);

    private final int value;

    LottoOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
