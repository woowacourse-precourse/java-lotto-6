package System;

public enum Constant {
    LOTTO_MIN_VALUE(1),
    LOTTO_MAX_VALUE(45),
    LOTTO_PRICE(1000);

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

    private final int constant;
}
