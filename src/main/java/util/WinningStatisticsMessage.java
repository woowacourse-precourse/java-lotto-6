package util;

public enum WinningStatisticsMessage {
    RESULT_START("\n당첨 통계"),
    BAR("---"),
    COUNT_RANK("%d개 일치 (%s원) - %d개\n"),
    COUNT_RANK_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    FORMAT_WITH_COMMA("###,###,###,###"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    WinningStatisticsMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}