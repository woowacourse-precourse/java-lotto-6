package System;

public enum Constant {
    LOTTO_MIN_VALUE(1),
    LOTTO_MAX_VALUE(45),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000),
    STATICS_FIRST_PRIZE(200000000),
    STATICS_SECOND_PRIZE(30000000),
    STATICS_THIRD_PRIZE(1500000),
    STATICS_FOURTH_PRIZE(50000),
    STATICS_FIFTH_PRIZE(5000);

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

    private final int constant;
}
