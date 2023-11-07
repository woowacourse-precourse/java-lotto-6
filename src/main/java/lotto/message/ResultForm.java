package lotto.message;

public enum ResultForm {
    ANNOUNCE_INIT("당첨 통계\n---\n"),
    FIFTH_PLACE("3개 일치 (5,000원) - %d개\n"),
    FOURTH_PLACE("4개 일치 (50,000원) - %d개\n"),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개\n"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개\n"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.\n");

    private final String resultFormat;


    ResultForm(String messageFormat) {
        this.resultFormat = messageFormat;
    }

    public String getResultFormat() {
        return resultFormat;
    }
}
