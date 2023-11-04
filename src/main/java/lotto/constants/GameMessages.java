package lotto.constants;

public enum GameMessages {
    INPUT_MONEY("구입금액을 입력해 주세요.");

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
