package lotto.enums;

public enum ErrorMessage {
    INVALID_PURCHASE_NUMBER_FORMAT("[ERROR] 구입 금액 숫자 형식이 올바르지 않습니다."),
    INVALID_WINNING_NUMBER_FORMAT("[ERROR] 당첨 번호 숫자 형식이 올바르지 않습니다."),
    INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 번호는 1부터 45사이 입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public final String getType() {
        return message;
    }
}
