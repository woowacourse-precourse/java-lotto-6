package lotto.validation.enumType;

public enum AmountInput {
    NUMERIC_FORMAT_MESSAGE("[ERROR] 숫자만 입력할 수 있습니다."),
    POSITIVE_MESSAGE("[ERROR] 양수 값을 입력해야 합니다."),
    VALUE_DIVIDE_MESSAGE("[ERROR] 1000원 단위로 값을 입력해야 합니다."),
    ONE_LOTTO_PRICE(1000),
    POSITIVE_CHECK_NUMBER(1);

    private String message;
    private int number;

    AmountInput(final String message) {
        this.message = message;
    }

    AmountInput(final int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
