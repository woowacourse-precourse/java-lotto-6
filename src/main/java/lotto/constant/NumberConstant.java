package lotto.constant;

public enum NumberConstant {

    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(2),
    LOTTO_COUNT(6);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
