package lotto.view.constant;

public enum Message {
    ASK_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    NOTICE_PURCHASE_QUANTITY("\n%d개를 구매했습니다."),
    NOTICE_STATS_SUBJECT("\n당첨 통계\n---"),
    NOTICE_TOTAL_PROFIT("총 수익률은 %.1f%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
