package lotto.exception;

public enum ExceptionMessage {
    INVALID_NUMBER("1000원 단위의 숫자를 입력하세요."),
    INVALID_WINNING_NUMBER("당첨 번호는 1~45 사이의 중복되지 않은 6개 숫자이어야합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 1~45 사이의 숫자이며, 당첨 번호와 중복되지 않아야 합니다.");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
