package lotto.message;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NO_INTEGER("입력값이 정수가 아닙니다."),
    NO_POSITIVE_INTEGER("구입금액은 양수여야 합니다."),
    UNIT_RESTRICTION("구입금액은 1,000원 단위여야 합니다."),
    NOT_LENGTH_SIX("당첨 번호는 6개여야 합니다."),
    HAS_DUPLICATED_NUMBER("당첨 번호에 중복이 존재합니다."),
    HAS_DUPLICATED_WINNING_NUMBER_WITH_BONUS_NUMBER("당첨 번호와 보너스 번호가 중복입니다.");

    private final String errorMessage;
    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
