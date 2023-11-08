package lotto.constant.view;

public enum OutputView {
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---"),
    WINNING_RESULT_MESSAGE("%d개 일치 (%s원) - %d개\n"),
    BONUS_RESULT_MESSAGE("5개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    EARNING_RATE_MESSAGE("총 수익률은 %,.1f%%입니다.");

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
