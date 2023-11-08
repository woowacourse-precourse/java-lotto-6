package lotto.util;

public enum ConstantNumbers {
    TICKET_PRICE(1000),
    MINIMUM_Lotto_NUMBER(1),
    MAXIMUM_Lotto_NUMBER(45),
    LOTTO_NUMBER_QUANTITY(6),
    LOTTO_GRADE_QUANTITY(5),
    LOTTO_FIRST_CUT_LINE(6),
    LOTTO_SECOND_CUT_LINE(5),
    LOTTO_THIRD_CUT_LINE(5),
    LOTTO_FOURTH_CUT_LINE(4),
    LOTTO_FIFTH_CUT_LINE(3),
    LOTTO_FIRST_MONEY(2000000000),
    LOTTO_SECOND_MONEY(30000000),
    LOTTO_THIRD_MONEY(1500000),
    LOTTO_FOURTH_MONEY(50000),
    LOTTO_FIFTH_MONEY(5000);

    private final Integer constantNumber;

    ConstantNumbers(Integer constantNumber) {
        this.constantNumber = constantNumber;
    }

    public Integer getConstant() {
        return constantNumber;
    }
}
