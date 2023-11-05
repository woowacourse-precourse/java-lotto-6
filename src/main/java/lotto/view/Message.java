package lotto.view;

public enum Message {
    PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요"),
    TICKET_COUNT_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
