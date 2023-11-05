package lotto.constant;

public enum NumberConstant {
    LOTTO_NUMBER_START_INCLUSIVE(1),
    LOTTO_NUMBER_END_INCLUSIVE(45),
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_LIMIT(6);
    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int value() {
        return this.number;
    }
}
