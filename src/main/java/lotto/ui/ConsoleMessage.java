package lotto.ui;

public enum ConsoleMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_LOTTOS("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_RESULT_HEADER("당첨 통계\n---"),
    PRINT_RESULT_FORMAT("%d개 일치 (%,d원) - %d개"),
    PRINT_SECOND_RESULT_FORMAT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    PRINT_RATE_OF_PRIZE_FORMAT("총 수익률은 %.1f%%입니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
