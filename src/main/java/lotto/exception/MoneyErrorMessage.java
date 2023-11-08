package lotto.exception;

public enum MoneyErrorMessage {
    MONEY_UNIT_ERROR("로또 구입 금액은 1000원 단위로 가능합니다."),
    MONEY_ZERO_ERROR("로또 구입 금액은 0원 이상이어야 합니다."),
    MONEY_FORMAT_ERROR("로또 구입 금액은 숫자로 입력해주세요.");

    private final String message;
    private final String ERROR = "[ERROR] ";

    MoneyErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
