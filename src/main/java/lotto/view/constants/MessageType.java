package lotto.view.constants;

public enum MessageType {
    COST_REQUEST_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
