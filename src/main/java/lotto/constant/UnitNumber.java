package lotto.constant;

public enum UnitNumber {
    LOTTO_PRICE(1000),
    WINNING_COUNT(6),
    ZERO(0),
    PERCENTAGE(100),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    ROUNDED_HELPER_NUMBER(100);


    private int number;

    UnitNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
