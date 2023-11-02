package lotto.domain;

public enum Constant {
    MIN(1),
    MAX(45),
    CASH_UNIT(1000);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
