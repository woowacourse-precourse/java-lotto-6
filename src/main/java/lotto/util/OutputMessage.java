package lotto.util;


public enum OutputMessage {
    COUNT_PURCHASED_TICKETS("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    COUNT_MATCH_3("3개 일치 (5,000원) - %d개"),
    COUNT_MATCH_4("4개 일치 (50,000원) - %d개"),
    COUNT_MATCH_5("5개 일치 (1,500,000원) - %d개"),
    COUNT_MATCH_5_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    COUNT_MATCH_6("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}