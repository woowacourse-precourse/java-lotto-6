package lotto.util;

public enum ConstantNumbers {
    RESET_INTEGER_NUMBER(0),
    TICKET_PRICE(1000);

    private final Integer constantNumber;

    ConstantNumbers(Integer constantNumber) {
        this.constantNumber = constantNumber;
    }

    public Integer getConstant() {
        return constantNumber;
    }
}
