package lotto.domain.Constant;

public enum OutputViewMessage {
    PRINT_ATTEMPT("%d개를 구매했습니다.\n"),
    PRINT_STAT("당첨 통계\n---"),
    PRINT_STAT_MATCH3("3개 일치 (5,000원) - %d개\n"),
    PRINT_STAT_MATCH4("4개 일치 (50,000원) - %d개\n"),
    PRINT_STAT_MATCH5("5개 일치 (1,500,000원) - %d개\n"),
    PRINT_STAT_MATCH5_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    PRINT_STAT_MATCH6("6개 일치 (2,000,000,000원) - %d개\n"),
    PRINT_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private String message;

    private OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
