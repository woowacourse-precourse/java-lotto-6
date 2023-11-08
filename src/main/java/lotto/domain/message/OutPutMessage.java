package lotto.domain.message;

public enum OutPutMessage {
    BUYING_COUNT_FORMAT("%d개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---"),
    WINNING_STATISTICS("총 수익률은 %.1f%%입니다.");

    private String value;

    OutPutMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
