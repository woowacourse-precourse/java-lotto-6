package lotto.enums;

public enum Constant {

    NUMBER_FOR_INITIALIZATION(0),
    AMOUNT_OF_CORRECT_NUMBER(5),
    CORRECT_WITH_BONUS_NUMBER(7),
    PERCENT(100),
    AMOUNT_OF_LOTTO_NUMBER(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    MONEY_UNIT(1000);

    private final int value;

    Constant(int value) {
        this.value= value;
    }
    public int getValue() {
        return value;
    }
}
