package lotto.config;

public enum LottoMessage {
    LOTTO_PURCHASE_MESSAGE("구입 금액을 입력해주세요"),
    LOTTO_PURCHASE_CHECK_MESSAGE("%d개를 구매했습니다.\n"),
    LOTTO_NUMBER_MESSAGE("[%d, %d, %d, %d, %d, %d]\n"),
    LOTTO_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해주세요."),
    LOTTO_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해주세요."),
    LOTTO_STATISTICS_MESSAGE("당첨 통계"),
    GRAPH_UNDER_BAR("---"),
    LOTTO_WINNING_RESULT_MESSAGE("%d개 일치 (%,d원) - %d개\n"),
    LOTTO_WINNING_RESULT_BONUS_MESSAGE("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    LOTTO_TOTAL_PROFIT_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;
    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
