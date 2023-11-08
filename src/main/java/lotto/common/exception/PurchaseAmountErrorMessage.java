package lotto.common.exception;

public enum PurchaseAmountErrorMessage {

    NOT_NULL("구매 금액은 NULL이 아닙니다."),
    NOT_BLANK("구매 금액은 빈 값이 아닙니다."),
    NOT_NEGATIVE_NUMBER("구매 금액은 음수가 아닙니다."),
    NOT_DIVIDE_BY_LOTTO_PRICE("구매 금액은 로또 가격 단위이어야 합니다.");

    private final String errorMessage;

    PurchaseAmountErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
