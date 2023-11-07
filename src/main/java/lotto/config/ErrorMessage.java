package lotto.config;

public enum ErrorMessage {
    INVALID_INTEGER_INPUT("[ERROR] 입력이 정수가 아닙니다."),
    NUMBER_NOT_PRESENT("[ERROR] 숫자가 입력되지 않았습니다."),
    NUMBER_RANGE_ERROR("[ERROR] 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    MISSING_WINNING_NUMBERS("[ERROR] 당첨 번호를 입력해주세요."),
    LOTTO_NUMBERS_SIZE_ERROR("[ERROR] 로또 번호는 %d개여야 합니다."),
    WINNING_NUMBERS_SIZE_ERROR("[ERROR] 당첨 번호는 %d개여야 합니다."),
    BONUS_NUMBER_DUPLICATION("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 %,d원 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}
