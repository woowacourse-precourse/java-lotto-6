package lotto.constant;

public enum Constant {
    SIZE_OF_LOTTO_NUMBERS(6),
    MINMUM_LOTTO_NUMBER(1),
    MAXMUM_LOTTO_NUMBER(45),
    UNIT_OF_LOTTO_PURCHASE_AMOUNT(1_000),
    MINMUM_LOTTO_PURCHASE_AMOUNT(1_000),
    MAXMUM_LOTTO_PURCHASE_AMOUNT(100_000);

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
