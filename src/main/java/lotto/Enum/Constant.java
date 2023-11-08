package lotto.Enum;

public enum Constant {

    NUMBER_FOR_INITIALIZATION(0),
    AMOUNT_OF_CORRECT_NUMBER(5),
    CORRECT_WITH_BONUS_NUMBER(7),
    PERCENT(100);

    private final int value;

    Constant(int value) {
        this.value= value;
    }

    public int getValue() {
        return value;
    }
}
