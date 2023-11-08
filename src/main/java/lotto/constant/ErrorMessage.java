package lotto.constant;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    AMOUNT_WRONG("구매 금액은 1,000원 단위여야 합니다."),
    NUMBER_RANGE_WRONG("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_NUMBER_COUNT_WRONG("당첨 번호는 6개의 숫자여야 합니다."),
    BONUS_NUMBER_COUNT_WRONG("보너스 번호는 1개의 숫자여야 합니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
