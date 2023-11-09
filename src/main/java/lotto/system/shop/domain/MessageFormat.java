package lotto.system.shop.domain;

public enum MessageFormat {
    PURCHASE_AMOUNT_FORMAT("%d개를 구매했습니다."),
    WINNING_PRINT_FORMAT("%d개 일치 (%s원) - %d개"),
    WINNING_BONUS_PRINT_FORMAT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    RATE_OF_RETURN_FORMAT("총 수익률은 %.1f%%입니다."),;

    private final String format;

    MessageFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
