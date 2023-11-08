package lotto.util;

public enum UtilErrorMessages {

    INVALID_NUMBER_FORMAT("유효하지 않은 숫자 형식입니다"),
    INVALID_FORMAT_MESSAGE("입력 형식이 올바르지 않습니다. '숫자,숫자,숫자...' 형식으로 입력해주세요.");

    private final String message;

    UtilErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
