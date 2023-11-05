package lotto.view;

public enum OutputViewMessage {
    PAYMENT("구입금액을 입력해 주세요.");

    private final String message;
    OutputViewMessage(String message) {
        this.message = message;
    }

    protected String getMessage() {
        return message;
    }
}