package lotto.constant.messages;

public enum Notification {
    BUDGET("구입금액을 입력해 주세요."),
    PURCHASED("%d개를 구매했습니다."),
    WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    BONUS_LOTTO("보너스 번호를 입력해 주세요."),
    RESULT_PRE("당첨 통계\n"
            + "---"),
    RESULT_MATCHED("%d개 일치"),
    RESULT_PRIZE(" (%,d원) "),
    RESULT_WON("- %d개 "),
    RESULT_BONUS(", 보너스 볼 일치"),
    RESULT_PROFIT("총 수익률은 %.1f%%입니다.");


    private final String message;

    Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}