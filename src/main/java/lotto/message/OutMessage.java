package lotto.message;

public enum OutMessage {
    OUT_NUMBER_OF_LOTTO("\n%s개를 구매했습니다."),
    OUT_WINNING_STATISTICS("당첨 통계\n---"),
    OUT_LOTTO_RESULT_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),

    OUT_TOTAL_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
