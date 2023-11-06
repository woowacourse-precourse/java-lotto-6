package lotto.constant;

public enum DrawMessage {
    ENTER_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_MESSAGE("\n%d개를 구매했습니다.\n"),
    ENTER_WINNER_NUMBERS_MESSAGE("당첨 번호를 입력해주세요."),
    ENTER_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해주세요."),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
    TOTAL_PROFIT_MESSAGE("총 수익률은 %s입니다."),
    NO_BONUS_WINNING_RESULT_MESSAGE("%d개 일치 (%s원) - %d개"),
    BONUS_WINNING_RESULT_MESSAGE("%d개 일치, 보너스 볼 일치 (%s원) - %d개");
    private final String string;

    DrawMessage(String string) {
        this.string = string;
    }

    public String getMessage() {
        return string;
    }
}
