package lotto.constant;

public enum GeneralMessage {
    ASK_BUY_PRICE("구입금액을 입력해 주세요.");

    private final String message;

    GeneralMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
