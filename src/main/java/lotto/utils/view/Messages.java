package lotto.utils.view;

public enum Messages {
    SETUP_BUY_PRICE_MESSAGE("\n구매금액을 입력해 주세요."),
    ;

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
