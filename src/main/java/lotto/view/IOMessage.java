package lotto.view;

public enum IOMessage {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PRINT_PURCHASED_LOTTO("\n%d개를 구매했습니다."),
    PRINT_WINNING_STATS("\n당첨 통계 \n---"),
    PRINT_WINNING_RATE("%d개 일치 (%s원) - %d개"),
    PRINT_WINNING_RATE_WITH_BONUS_NUMBER("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    PRINT_ERROR_MESSAGE_START("[ERROR] %s"),
    PRINT_EARNING_RATE("총 수익률은 %.1f%%입니다. \n");

    final String message;

    IOMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
