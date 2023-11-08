package lotto.util;

public enum Message {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    LOTTERY_STATISTICS("\n당첨 통계\n---"),
    TOTAL_PROFIT_PERCENT("총 수익률은 %.1f%%입니다."),

    NUMBER_OF_TICKET_PURCHASED("\n%d개를 구매했습니다."),
    FIFTH("3개 일치 (5,000원) - %d개"),
    FOURTH("4개 일치 (50,000원) - %d개"),
    THIRD("5개 일치 (1,500,000원) - %d개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST("6개 일치 (2,000,000,000원) - %d개");

    private final String message;


    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
