package lotto.constant;

public enum LottoNumber {
    ZERO(0),
    WINNING_NUMBER_LENGTH(6),
    MINIMUM_WINNING_NUMBER(1),
    MAXIMUM_WINNING_NUMBER(45),
    PURCHASE_UNIT(10);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
