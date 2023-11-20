package lotto.message;

public enum ConsoleMessage {
    ASK_FOR_PRICE("구입금액을 입력해 주세요."),
    NOTICE_PURCHASE("개를 구매했습니다."),
    ASK_FOR_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_FOR_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    NOTICE_STAT("당첨 통계"),
    HORIZONTAL_RULE("---"),
    NOTICE_YIELD("총 수익률은 "),
    LINE_BREAK("\n");

    private final String consoleMessage;

    ConsoleMessage(String consoleMessage) {
        this.consoleMessage = consoleMessage;
    }

    public String getMessage() {
        return this.consoleMessage;
    }
}
