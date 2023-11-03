package lotto.view;

public enum InputMessage {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
