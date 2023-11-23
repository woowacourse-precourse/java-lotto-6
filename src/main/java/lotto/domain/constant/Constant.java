package lotto.domain.constant;

public enum Constant {

    ZERO(0),
    ALLOWED_MAXIMUM_AMOUNT(100_000);

    private final int constant;

    Constant(final int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return this.constant;
    }
}
