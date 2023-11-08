package lotto.constants;

public enum OutputMessages {

    LOTTO_PURCHASE_MESSAGE("%d개를 구매했습니다.\n"),
    WINNING_STATISTIC_MESSAGE("\n당첨 통계"),
    HORIZONTAL_RULE("---"),
    THREE_MATCH_PRIZE("3개 일치 (5,000원) - %d개\n"),
    FOUR_MATCH_PRIZE("4개 일치 (50,000원) - %d개\n"),
    FIVE_MATCH_PRIZE("5개 일치 (1,500,000원) - %d개\n"),
    FIVE_BONUS_MATCH_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX_MATCH_PRIZE("6개 일치 (2,000,000,000원) - %d개\n"),
    TOTAL_REVENUE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}