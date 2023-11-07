package lotto.view;

public enum Messages {
    ASK_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_SUCCESS("%d개를 구매했습니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCountMessage(int count) {
        return String.format(message, count);
    }
}
