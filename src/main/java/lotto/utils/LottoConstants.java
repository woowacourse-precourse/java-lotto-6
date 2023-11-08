package lotto.utils;

public enum LottoConstants {

    LOTTO_TICKET_PURCHASE_AMOUNT(1000),
    LOTTO_NUMBERS(6),
    START_NUMBER(1),
    END_NUMBER(45),
    NUMBER_OF_ROUNDING_DIGITS(1),
    FIVE_WINS(5),
    THREE_WINS(3),
    ALL_WINS(6),
    NO_WIN(0),
    FIFTH_PLACE(1),
    FIRST_PLACE(6),
    LAST_PLACE_WINNING_AMOUNT(0),
    FIFTH_PLACE_WINNING_AMOUNT(5000),
    FOURTH_PLACE_WINNING_AMOUNT(50000),
    THIRD_PLACE_WINNING_AMOUNT(1500000),
    SECOND_PLACE_WINNING_AMOUNT(30000000),
    FIRST_PLACE_WINNING_AMOUNT(2000000000);

    private final Integer value;

    LottoConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
