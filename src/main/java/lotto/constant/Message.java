package lotto.constant;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    BUY_MESSAGE_WITH_COUNT("개를 구매했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}