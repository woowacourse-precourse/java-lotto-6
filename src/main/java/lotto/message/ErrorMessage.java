package lotto.message;

public enum ErrorMessage {
    DIVISIBLE_BY_1000("[ERROR] 구입 금액은 1000원 단위여야 합니다");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
