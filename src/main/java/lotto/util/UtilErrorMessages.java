package lotto.util;

public enum UtilErrorMessages {

    INVALID_NUMBER_FORMAT("유효하지 않은 숫자 형식입니다");

    private final String message;

    UtilErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
