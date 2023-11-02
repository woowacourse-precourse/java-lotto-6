package lotto.validation;

public enum ErrorMessage {
    NO_MONEY("구매 금액이 부족합니다."),
    NUM_ERROR("구매금액은 양의 정수로 입력해야합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
