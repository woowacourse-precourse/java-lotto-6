package lotto.view;

public enum LottoMessage {
    PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    ENTER_WINNING_LOTTO_NUMBER("\n당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
    MATCH_AND_PRIZE_MESSAGE("%d개 일치%s (%,d원) - %d개"),
    BONUS_BALL_MATCH_MESSAGE(", 보너스 볼 일치"),
    TOTAL_PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다."),
    PURCHASE_LOTTO_AMOUNT_MESSAGE("\n%d개를 구매했습니다.\n");
    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

}
