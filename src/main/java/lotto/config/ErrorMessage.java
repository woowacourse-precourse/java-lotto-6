package lotto.config;

/**
 * 에러 메시지 관리를 위한 enum 클래스
 */
public enum ErrorMessage {
    TOO_LONG_INPUT_ERROR_MESSAGE("입력값은 9자리 이하로 해주세요."),
    INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE("구입 금액에는 숫자만 있어야 합니다."),
    INPUT_AMOUNT_DIVISION_ERROR_MESSAGE("구입 금액은 1000으로 나누어 떨어져야 합니다."),
    INPUT_AMOUNT_TOO_LARGE_ERROR_MESSAGE("한번에 10000장 이상을 구매할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
