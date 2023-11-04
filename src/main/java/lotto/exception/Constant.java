package lotto.exception;

public enum Constant {

    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
