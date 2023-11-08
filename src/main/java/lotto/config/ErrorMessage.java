package lotto.config;

/**
 * 에러 메시지 관리를 위한 enum 클래스
 */
public enum ErrorMessage {
    INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE("구입 금액에는 숫자만 있어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
