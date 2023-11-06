package lotto.util.message;

public enum Digit {

    MONEY_UNIT(1000),
    LOTTO_SIZE(6),
    LOTTO_RANGE_START(1),
    LOTTO_RANGE_END(45);

    private final int number;

    Digit(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
