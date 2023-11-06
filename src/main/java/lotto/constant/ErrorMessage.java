package lotto.constant;

public enum ErrorMessage {
    NOT_POSITIVE_ERROR("[ERROR] 입력이 양수여야 합니다."),
    THOUSAND_UNIT_ERROR("[ERROR] 입력이 1000 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}