package lotto.domain;

public enum ErrorMessage {
    BUDGET_INPUT_ERROR("[ERROR] 구매 금액은 1000으로 나누어 떨어지는 숫자여야 합니다."),
    WINNING_INPUT_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_INPUT_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
