package lotto.exception;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    NOT_INTEGER(ERROR.getMessage() + "숫자를 입력해주세요."),
    UNFIT_UNIT(ERROR.getMessage() + "1,000원 단위로 입력해주세요."),
    WRONG_SIZE(ERROR.getMessage() + "당첨 번호는 6개여야 합니다. 쉼표(,)로 구분하여 입력해주세요."),
    OUTSIDE_RANGE(ERROR.getMessage() + "당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_WINNING_NUMBERS(ERROR.getMessage() + "당첨 번호는 서로 다른 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER(ERROR.getMessage() + "보너스 번호는 당첨 번호와 다른 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public static IllegalArgumentException newIllegalArgumentException(ErrorMessage errorMessage) {
        return new IllegalArgumentException(errorMessage.getMessage());
    }

    public String getMessage() {
        return message;
    }
}
