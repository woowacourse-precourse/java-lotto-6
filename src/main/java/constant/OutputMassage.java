package constant;

public enum OutputMassage {
    PURCHASE("\n%d개를 구매했습니다.\n"),
    WINNING_STATISTIC("당첨 통계\n---\n"),
    WINNING_RESULT("%d개 일치 (%s)원 - %d개\n"),
    WINNING_BONUS_RESULT("5개 일치, 보너스 볼 일치 (%s)원 - %d개\n"),
    WINNING_RATE("총 수익률은 %.1f%%입니다.");
    private final String message;

    OutputMassage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
