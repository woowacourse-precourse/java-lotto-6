package lotto.ui;

public enum ConsoleMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_LOTTOS("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
