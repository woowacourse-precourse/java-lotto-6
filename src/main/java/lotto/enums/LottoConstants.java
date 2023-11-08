package lotto.enums;

public enum LottoConstants {
    LOTTO_TICKET_PRICE(1000),
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    NUMBERS_PER_TICKET(6);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
