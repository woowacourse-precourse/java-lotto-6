package lotto.utils.constants;

public enum ExceptionMessage {
    PURCHASE_AMOUNT_NOT_NUMBER("숫자로 된 구매 금액을 입력해주세요."),
    PURCHASE_AMOUNT_BLANK("아무 값도 입력하지 않았습니다. 숫자로 된 구매 금액을 입력해주세요."),
    PURCHASE_AMOUNT_NOT_THOUSAND("1,000원 단위의 구매 금액을 입력해주세요.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = "[ERROR]" + message;
    }

    public String getMessage() {
        return message;
    }
}
