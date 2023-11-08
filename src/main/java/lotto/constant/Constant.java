package lotto.constant;

public enum Constant {
    SIZE_OF_LOTTO_NUMBERS(6),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_PRICE(1_000),
    MAXIMUM_PURCHASE_AMOUNT(100_000);

    private final int constantNumber;

    Constant(int constantNumber) {
        this.constantNumber = constantNumber;
    }

    public int getValue() {
        return constantNumber;
    }

    @Override
    public String toString() {
        return this.name() + " = " + String.valueOf(constantNumber);
    }
}
