package lotto.error;

public enum ErrorMessage {
    INVALID_LOTTO_PURCHASE_AMOUNT("유효하지 않은 로또 구매 금액을 입력했습니다."),
    INVALID_WINNING_NUMBERS("유효하지 않은 당첨 번호를 입력했습니다"),
    INVALID_BONUS_NUMBER("유효하지 않은 보너스 번호를 입력했습니다");

    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
