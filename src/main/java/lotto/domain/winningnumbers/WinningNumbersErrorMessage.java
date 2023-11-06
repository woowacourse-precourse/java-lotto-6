package lotto.domain.winningnumbers;

public enum WinningNumbersErrorMessage {
    BONUS_NUMBER_DUPLICATION_ERROR("[ERROR] 보너스 번호는 당첨 번호에 없는 숫자여야 합니다."),
    BONUS_NUMBER_INVALID_RANGE("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");

    private final String message;

    WinningNumbersErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
