package lotto;

public enum ErrorMessage {
    NOT_SEPARATED_1000("1000원 단위의 숫자만 입력해 주세요."),
    NOT_A_NUMBER("숫자만 입력해 주세요."),
    INVALID_WINNING_NUMBER("올바르지 않은 당첨 번호입니다."),
    INVALID_BONUS_NUMBER("올바르지 않은 보너스 번호입니다.")
    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        String baseErrorMessage = "[ERROR] ";
        return baseErrorMessage + errorMessage;
    }
}
