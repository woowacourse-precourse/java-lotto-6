package lotto.constant;

public enum OutputMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_TICKET_COUNT("%d개를 구매했습니다."),
    NUMBER_DELIMITER(", "),
    NEW_LINE("\n"),
    READ_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    READ_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    MATCH_COUNT("%d개 일치"),
    BONUS_MATCH(", 보너스 볼 일치"),
    PRIZE_AMOUNT(" (%,d원) - "),
    WINNING_NUMBER("%d개\n"),
    PROFIT("총 수익률은 %.1f%%입니다."),
    WINNING_STATISTICS("당첨 통계"),
    LINE("---");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
