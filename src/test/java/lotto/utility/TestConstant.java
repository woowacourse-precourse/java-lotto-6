package lotto.utility;

public enum TestConstant {
    INIT_COST(10_000),
    LOTTO_PRICE(1_000),
    LOTTO_PRIZE(10_000_000),
    CONSTANT_ZERO(0),
    CONSTANT_ONE(1),
    VALID_GRADE(3),
    NOT_VALID_GRADE(7),
    VALID_MATCHED_NUMBER(5),
    BONUS_NUMBER(7)
    ;

    private final int constant;

    TestConstant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return this.constant;
    }
}
