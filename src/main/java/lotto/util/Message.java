package lotto.util;

public enum Message {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTERY_STATISTICS("당첨 통계"),
    TOTAL_PROFIT_PERCENT("총 수익률은 %.2f%입니다."),

    NUMBER_OF_TICKET_PURCHASED("%d개를 구매했습니다."),
    MATCH_3("3개 일치 (5,000원) - %d개"),
    MATCH_4("4개 일치 (50,000원) - %d개"),
    MATCH_5("5개 일치 (1,500,000원) - %d개"),
    MATCH_5_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCH_6("6개 일치 (2,000,000,000원) - %d개");

    private final String message;


    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
