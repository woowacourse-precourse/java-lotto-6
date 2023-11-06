package lotto.utils;

public enum ValueUnit {

    LOTTO_TICKET_PURCHASE_AMOUNT(1000),
    NUMBER_OF_ROUNDING_DIGITS(1),
    REMAINS(0),
    LOTTO_NUMBERS(6),
    COMMAS_NUMBERS(5),
    START_NUMBER(1),
    END_NUMBER(45),
    START_COUNT(0),
    FIVE_WINS(5),
    THREE_WINS(3),
    ALL_WINS(6),
    MINUS_ONE(1),
    MINUS_TWO(2),
    NO_WIN(0),
    FIFTH_PLACE(0),
    FIRST_PLACE(6),
    LAST_PLACE_WINNING_AMOUNT(0),
    FIFTH_PLACE_WINNING_AMOUNT(5000),
    FOURTH_PLACE_WINNING_AMOUNT(50000),
    THIRD_PLACE_WINNING_AMOUNT(1500000),
    SECOND_PLACE_WINNING_AMOUNT(30000000),
    FIRST_PLACE_WINNING_AMOUNT(2000000000),
    ZERO(0),
    PERCENT_CALCULATION(100),
    ONE(1)
    ;

    private Integer value;

    ValueUnit(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
