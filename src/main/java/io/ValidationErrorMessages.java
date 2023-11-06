package io;

public enum ValidationErrorMessages {
    NOT_INTEGER("정수를 입력해주세요."),
    BELOW_MINIMUM_PURCHASE_AMOUNT("최소 구입 금액은 1000원입니다."),
    NOT_MULTIPLE_OF_PRICE("1000원 단위로 입력해주세요.");

    private final String message;

    ValidationErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
