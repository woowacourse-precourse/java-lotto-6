package lotto.constant;


public enum Constant {
    NUMBERS_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    AVAILABLE_NUMBER(46);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


