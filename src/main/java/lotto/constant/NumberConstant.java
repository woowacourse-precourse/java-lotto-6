package lotto.constant;

public enum NumberConstant {
    LOTTO_NUMBER_START_INCLUSIVE(1),
    LOTTO_NUMBER_END_INCLUSIVE(45),
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_SIZE_LIMIT(6),
    LOTTO_SIZE(6),
    CHECK_BONUS_NUMBER_CONDITION(5),
    ZERO(0);
    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int value() {
        return this.number;
    }

}
