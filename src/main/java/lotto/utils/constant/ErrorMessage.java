package lotto.utils.constant;

public enum ErrorMessage {
    ERROR_HEAD("[ERROR] "),
    BLANK_ERROR_MESSAGE("빈 값을 입력할 수 없습니다"),
    INT_ERROR_MESSAGE("정수가 아닌 다른 문자는 입력할 수 없습니다"),
    WINNING_NUMBER_SIZE_ERROR_MESSAGE("쉼표를 기준으로 당첨 번호 6개를 입력해 주세요"),
    WINNING_NUMBER_RANGE_ERROR_MESSAGE("당첨 번호는 1부터 45까지의 숫자만 가능합니다"),
    WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE("당첨 번호는 중복되어선 안됩니다"),
    LOTTO_SIZE_ERROR_MESSAGE("로또는 6자리 숫자만 가능합니다"),
    LOTTO_RANGE_ERROR_MESSAGE("로또는 1부터 45까지의 숫자만 가능합니다"),
    LOTTO_DUPLICATION_ERROR_MESSAGE("로또 번호는 중복되어선 안됩니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_HEAD.message + message;
    }
}