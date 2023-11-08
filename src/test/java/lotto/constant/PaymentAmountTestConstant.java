package lotto.constant;

public enum PaymentAmountTestConstant {
    PAYMENT_AMOUNT("8000"),
    INVALID_TYPE_PAYMENT_AMOUNT("1000a"),
    INVALID_MULTIPLE_PAYMENT_AMOUNT("15001");

    private final String value;

    PaymentAmountTestConstant(java.lang.String value) {
        this.value = value;
    }

    public java.lang.String getValue() {
        return value;
    }
}
