package lotto.Exception;

public enum MoneyErrorMessage {
    INVALID_MONEY_INPUT("[ERROR] 로또 금액을 숫자로 입력해 주세요."),
    INVALID_AMOUNT_NOT_STANDARD_UNIT("[ERROR] 로또 금액은 1000단위로만 입력이 가능합니다.");

    private final String message;

    MoneyErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
