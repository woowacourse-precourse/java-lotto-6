package domain;

public enum ErrorCode {

    MONEY_NOT_INTEGER("\n[ERROR] 구입 금액은 정수로 입력되어야 합니다.\n"),
    MONEY_NOT_DIVIDE("\n[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.\n"),
    BALLS_NOT_SIX("\n[ERROR] 당첨 번호는 6개가 입력되어야 합니다.\n"),
    BALL_NOT_NUMBER("\n[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n"),
    BALL_DUPLICATE("\n[ERROR] 당첨 번호 내에는 중복된 숫자가 없어야 합니다.\n"),
    BONUS_BALL_DUPLICATE("\n[ERROR] 보너스 번호는 이미 입력된 당첨 번호와 중복되지 않은 숫자여야 합니다.\n");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
