package lotto;

public enum Error {
    NO_ERROR(""),
    ERROR_MSG_NUMBER_FORMAT("[ERROR] 숫자가 아닙니다."),
    ERROR_MSG_NUMBER_RANGE("[ERROR] 범위를 벗어납니다."),
    ERROR_MSG_UNIT("[ERROR] 단위가 올바르지 않습니다."),
    ERROR_MSG_SIZE("[ERROR] 개수가 올바르지 않습니다."),
    ERROR_MSG_BLANK("[ERROR] 공백이 포함되어 있습니다."),
    ERROR_MSG_DUPLICATED_BONUS("[ERROR] 보너스 숫자가 기존 숫자와 중복입니다."),
    ERROR_MSG_DUPLICATED_NUMBERS("[ERROR] 중복된 숫자가 존재합니다."),
    ERROR_MSG_NEGATIVE_NUMBER("[ERROR] 숫자가 음수입니다.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
