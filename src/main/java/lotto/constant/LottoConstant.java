package lotto.constant;

public enum LottoConstant {
    ERROR_MESSAGE("[ERROR]"),
    PURCHASE_AMOUNT_UNIT(1000),
    ZERO(0),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_LENGTH(6),
    LOTTO_NUMBER_SEPARATER(","),
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    FIRST_INDEX(4),
    SECOND_INDEX(3),
    THIRD_INDEX(2),
    FOURTH_INDEX(1),
    FIFTH_INDEX(0),
    FIRST_PRIZE_LONG(20000000000L),
    SECOND_PRIZE_INTEGER(30000000),
    THIRD_PRIZE_INTEGER(1500000),
    FOURTH_PRIZE_INTEGER(50000),
    FIFTH_PRIZE_INTEGER(5000),
    PERCENTAGE(100),
    ROUND_OFF_TO_THE_NEAREST_TENTH(10);

    private long constant;
    private String string;

    LottoConstant(long constant) {
        this.constant = constant;
    }

    LottoConstant(String letter) {
        this.string = letter;
    }

    public int getConstant() {
        return (int) constant;
    }

    public String getString() {
        return string;
    }
}
