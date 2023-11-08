package lotto.constants;

public enum OutputMessage implements Message {

    ANNOUNCE_PURCHASE_QUANTITY_FORMAT("%s개를 구매했습니다."),
    ANNOUNCE_WINNING_STATISTICS_START("당첨 통계"),
    STATISTICS_RANK_INFO_OUTPUT_FORMAT("%d개 일치 (%s원) - %d개\n"),
    STATISTICS_RANK_INFO_OUTPUT_FORMAT_INCLUDE_BONUS_BALL("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    DIVISION_LINE("---"),
    EARNING_RATE_OUTPUT_FORMAT("총 수익률은 %s%%입니다."), EARNING_RATE_NUMBER_FORMAT("#,##0.##"),
    ;


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
