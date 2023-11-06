package lotto.view.constants;

public enum PrizeResultFormat {
    RESPONSE_MATCHING("%d개 일치 (%s원) - %d개"),
    RESPONSE_MATCHING_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개");

    private final String format;

    PrizeResultFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
