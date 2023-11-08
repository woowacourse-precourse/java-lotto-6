package lotto.messages;

public enum OutputMessage {

    LOTTO_TICKETS_PURCHASED("\n%d개를 구매했습니다."),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    WINNING_STATISTIC("\n%d개 일치 (%s원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String outputView;

    OutputMessage(String outputView) {
        this.outputView = outputView;
    }

    public String getOutputView() {
        return outputView;
    }
}
