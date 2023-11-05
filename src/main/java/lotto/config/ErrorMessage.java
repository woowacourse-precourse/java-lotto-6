package lotto.config;

public enum ErrorMessage {

    ONLY_NUMBER_ERROR("[ERROR]숫자만 입력가능합니다."),
    NOT_THOUSAND_DIVIDED_ERROR("[ERROR] 금액은 1,000원 단위로만 입력이 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
