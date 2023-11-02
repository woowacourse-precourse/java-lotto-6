package lotto.global;

public enum ErrorMessage {
    NOT_MEET_PURCHASE_UNIT("구매 단위는 1,000 단위에요."),
    NOT_MEET_MINIMUM_PURCHASE_AMOUNT("최소 구매 금액은 1,000원이에요"),
    NOT_MEET_MAXIMUM_PURCHASE_AMOUNT("구매 금액은 20억원을 넘길 수 없어요.");

    private final String message;

    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
