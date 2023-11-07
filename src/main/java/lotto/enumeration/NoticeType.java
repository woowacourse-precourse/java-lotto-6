package lotto.enumeration;

public enum NoticeType {
    AMOUNT_INPUT("구입금액을 입력해 주세요."),
    TICKET_COUNT("개를 구매했습니다."),
    WINNING_LOTTO_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUM_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계\n---"),
    PROFIT_FRONT("총 수익률은 "),
    PROFIT_END("%입니다.");

    private String message;
    NoticeType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
