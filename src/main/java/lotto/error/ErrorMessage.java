package lotto.error;

public enum ErrorMessage {
    NOT_DIGIT_PRICE("[ERROR] 구입 금액은 숫자여야 합니다."),
    NEGATIVE_PRICE("[ERROR] 구입 금액은 음수일 수 없습니다."),
    NOT_THOUSAND_UNIT_PRICE("[ERROR] 구입 금액은 천 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
