package lotto.constants.messages;

public enum Notification {
    BUDGET("구입금액을 입력해 주세요."),
    PURCHASED("%d개를 구매했습니다."),
    WINNER_LOTTO("당첨 번호를 입력해 주세요."),
    BONUS_LOTTO("보너스 번호를 입력해 주세요."),
    RESULT_PRE("당첨 통계\n"
            + "---"),
    RESULT_MATCHED("%d개 일치 (%d원) - %d개"),
    RESULT_PROFIT("총 수익률은 %lf%입니다.");


    private final String message;

    Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}