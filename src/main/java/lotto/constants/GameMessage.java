package lotto.constants;

public enum GameMessage {
    PAY_INPUT_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
