package lotto.domain.constants;

public enum OutputViewMessage {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
