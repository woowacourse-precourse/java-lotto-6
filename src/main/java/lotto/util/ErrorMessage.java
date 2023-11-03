package lotto.util;

public enum ErrorMessage {
    ERROR_INFO("ERROR "),
    MONEY_ERROR("구매 금액은 1000원 단위의 숫자를 입력해 주세요. ex) 5000");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
