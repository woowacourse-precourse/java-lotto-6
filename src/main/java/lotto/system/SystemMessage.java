package lotto.system;

public enum SystemMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_ANTI_PATTERN_REGEX("[^0-9]+");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
