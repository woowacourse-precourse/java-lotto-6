package lotto.message;

public enum OutputMessage {
    OUTPUT_COUNT_OF_LOTTO_FORMAT("\n%d개를 구매했습니다."),

    WINNING_STATISTICS("\n당첨 통계\n---"),
    MATCHES_3_FORMAT("3개 일치 (5,000원) - %d개"),
    MATCHES_4_FORMAT("4개 일치 (50,000원) - %d개"),
    MATCHES_5_FORMAT("5개 일치 (1,500,000원) - %d개"),
    MATCHES_5_ADDITION_BONUS_NUMBER_FORMAT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCHES_6_FORMAT("6개 일치 (2,000,000,000원) - %d개"),

    TOTAL_RETURN("총 수익률은 %.1f%%입니다."),
    ;


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
