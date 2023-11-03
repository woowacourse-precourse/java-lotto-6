
package lotto.ui;

public enum OutputMessage {
    GET_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}