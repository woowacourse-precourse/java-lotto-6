package lotto.view.constant;

public enum PrizeMessage {

    WINNING_STATUS("당첨 통계"),
    LINE_SEPARATOR("---"),
    MATCHING_NUMBER_COUNT("%d개 일치"),
    MATCHING_BONUS_NUMBER(", 보너스 볼 일치"),
    PRIZE_MONEY(" (%s원)"),
    MONEY_FORMAT("#,###"),
    WINNING_COUNT(" - %d개"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");


    private final String message;

    PrizeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
