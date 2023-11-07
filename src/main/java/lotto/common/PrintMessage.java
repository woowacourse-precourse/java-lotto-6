package lotto.common;

public enum PrintMessage {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요."),
    PURCHASE_MESSAGE_FORMAT("%d개를 구매했습니다."),

    WINNING_STATISTICS_HEADER("당첨 통계"),
    WINNING_STATISTICS_SEPARATOR("---"),
    MATCH_COUNT_FORMAT("%d개 일치"),
    BONUS_BALL_FORMAT(", 보너스 볼 일치"),
    PRIZE_AMOUNT_FORMAT(" (%s원)"),
    MATCHING_COUNT_FORMAT(" - %d개"),
    TOTAL_ROI_MESSAGE_FORMAT("총 수익률은 %s%%입니다.");


    private String message;

    PrintMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }
}
