package lotto.view;

public enum OutputFormat {
    ISSUANCE_NUMBER_VIEW("%d개를 구매했습니다.\n"),
    RESULT_RANK_COUNT_VIEW("당첨 통계\n"
        + "---\n"
        + "3개 일치 (5,000원) - %d개\n"
        + "4개 일치 (50,000원) - %d개\n"
        + "5개 일치 (1,500,000원) - %d개\n"
        + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
        + "6개 일치 (2,000,000,000원) - %d개"),
    RESULT_INCOME_VIEW("총 수익률은 %s입니다.\n");

    private final String format;

    OutputFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
