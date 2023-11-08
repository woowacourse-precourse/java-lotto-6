package lotto.type;

public enum ErrorCode {
    INVALID_MONEY_TYPE("[ERROR] 구입 금액은 숫자만 가능합니다."),
    INVALID_MONEY_TO_BUY("[ERROR] 구입 금액은 1,000원 단위만 가능합니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨 번호는 서로 다른 1부터 45 사이의 6개 숫자만 가능합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자만 가능합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
