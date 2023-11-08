package lotto.constants;

public enum GameMessage {
    PAY_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PAY_OUTPUT_MESSAGE("\n%d개를 구매했습니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
