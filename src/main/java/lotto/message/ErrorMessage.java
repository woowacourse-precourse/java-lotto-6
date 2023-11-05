package lotto.message;

public enum ErrorMessage implements MessageProvider{
    INVALID_INPUT("[ERROR] 입력 형식이 잘못되었습니다."),
    INVALID_COUNT_FORMAT("[ERROR] 숫자 형식으로 입력해주세요."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 1,000원 단위로 입력해주세요.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
