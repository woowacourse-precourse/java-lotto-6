package lotto.util;

public enum ConstantNumbers {
    RESET_INTEGER_NUMBER(0),
    TICKET_PRICE(1000),
    MINIMUM_Lotto_NUMBER(1),
    MAXIMUM_Lotto_NUMBER(45),
    LOTTO_NUMBER_QUANTITY(6);

    private final Integer constantNumber;

    ConstantNumbers(Integer constantNumber) {
        this.constantNumber = constantNumber;
    }

    public Integer getConstant() {
        return constantNumber;
    }
}
