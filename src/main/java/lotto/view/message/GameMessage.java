package lotto.view.message;

public enum GameMessage {
    PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요"),
    TICKET_COUNT_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    RESULT_MESSAGE("당첨 통계"),
    DIVISION_LINE("---");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
