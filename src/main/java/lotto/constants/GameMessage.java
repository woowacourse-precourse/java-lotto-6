package lotto.constants;

public enum GameMessage {
    PAY_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PAY_OUTPUT_MESSAGE("\n%d개를 구매했습니다."),
    WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
