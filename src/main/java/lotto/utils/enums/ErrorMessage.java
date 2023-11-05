package lotto.utils.enums;

public enum ErrorMessage {
    NOT_NUMBER("유효한 숫자 형식이 아닙니다. 다시 입력해 주세요."),
    LACK_NUMBER_COUNT("숫자는 6개여야 합니다."),
    NUMBER_NOT_INRANGE("번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DUPLICATED("모든 숫자는 중복되지 않아야 합니다."),
    NOT_BLANK_NUMBER("숫자를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
