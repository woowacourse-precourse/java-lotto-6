package util;

public enum ErrorMessage {
    ONLY_INPUT_NUMBER("[ERROR] 숫자만 입력해 주세요"),
    AMOUNT_MUST_BE_DIVIDED_BY_PRICE("[ERROR] 금액은 1000단위 여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
