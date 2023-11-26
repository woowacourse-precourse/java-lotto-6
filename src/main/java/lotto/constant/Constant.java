package lotto.constant;

public enum Constant {

    ZERO(0),
    OPERAND(10),
    PRICE_PER_LOTTO(1000),
    ALLOWED_MAXIMUM_AMOUNT(100_000),
    ALLOWED_MINIMUM_NUMBER(1),
    ALLOWED_MAXIMUM_NUMBER(45),
    ALLOWED_SIZE_PER_LOTTO(6);


    private final int constant;

    Constant(final int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return this.constant;
    }
}
