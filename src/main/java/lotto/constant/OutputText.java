package lotto.constant;

public enum OutputText {
    LOTTO_COUNT("개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    DIVISION_LINE("---"),
    WINNING_STATISTICS_FORMAT("%s (%s원) - %d개"),
    RATE_OF_RETURN_FORMAT("총 수익률은 %s%%입니다.");

    private String value;

    OutputText(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
