package lotto.utils;

public enum Constants {
    // Value, Fields, Constructor
    TICKET_PRICE(1000),
    RANGE_MIN(1),
    RANGE_MAX(45),
    LOTTO_NUMBER_LENGTH(6),
    WINNING_NUMBER_LENGTH(7),
    NOT_VALUE(-1);

    private int integer;

    Constants(int integer) {
        this.integer = integer;
    }


    // Features
    public int getValue() {
        return integer;
    }
}
