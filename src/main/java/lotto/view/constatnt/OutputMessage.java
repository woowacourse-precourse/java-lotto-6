package lotto.view.constatnt;

public enum OutputMessage {

    INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    NOTICE_PURCHASE_COUNT("개를 구매했습니다."),
    NOTICE_WINNING_STATISTICS("\n당첨 통계\n---"),
    NOTICE_STATISTICS1("총 수익률은 "),
    NOTICE_STATISTICS2("%입니다."),
    COUNT("개");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
