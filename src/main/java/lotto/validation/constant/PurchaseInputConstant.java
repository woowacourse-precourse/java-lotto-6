package lotto.validation.constant;

public enum PurchaseInputConstant {
    POSITIVE_MESSAGE("[ERROR] 양수 값을 입력해야 합니다."),
    VALUE_DIVIDE_MESSAGE("[ERROR] 1000원 단위로 값을 입력해야 합니다."),
    ONE_LOTTO_PRICE(1000),
    POSITIVE_CHECK_NUMBER(1);

    private String message;
    private int number;

    PurchaseInputConstant(final String message) {
        this.message = message;
    }

    PurchaseInputConstant(final int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
