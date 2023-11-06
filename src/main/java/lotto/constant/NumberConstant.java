package lotto.constant;

public enum NumberConstant {

    PERCENT(100),
    MONEY_UNIT(1000),
    ZERO(0),
    NUMBERS_LENGTH(6),
    SAME_COUNT_FIVE(5),
    START_LOTTO_NUMBER(1),
    LAST_LOTTO_NUMBER(45);


    private int number;

    NumberConstant(int number) {
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

}
