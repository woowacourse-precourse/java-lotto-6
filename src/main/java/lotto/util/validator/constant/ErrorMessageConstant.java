package lotto.util.validator.constant;

public enum ErrorMessageConstant {
    WINNING_LENGTH_NOT_SIX_MESSAGE("당첨 번호는 6개 입력하셔야합니다."),
    WINNING_NUMBER_DUPLICATE_MESSAGE("당첨 번호는 서로 다른 수로 이루어져야합니다."),
    WINNING_NUMBER_IS_NOT_NUMERIC("당첨 번호는 숫자로 이루어져야합니다."),
    WINNING_NUMBER_RANGE_ERROR_MESSAGE("각 당첨 번호는 1~45 의 숫자여야 합니다."),
    BONUS_NUMBER_IS_NOT_NUMERIC("보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_RANGE_ERROR_MESSAGE("보너스 번호는 1~45 의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_WINNING_NUMBER("보너스 번호는 당첨 번호와 달라야합니다.");

    private static final String ERROR = "[ERROR] ";
    private final String message;

    ErrorMessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
