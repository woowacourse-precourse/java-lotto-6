package lotto.constants;

public enum Message {
    NEW_LINE(System.lineSeparator()),
    ASK_PURCHASE("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT("%d개를 구매했습니다." + NEW_LINE.message),
    ASK_WINNING_NUMBER(NEW_LINE.message + "당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER(NEW_LINE.message + "보너스 번호를 입력해 주세요."),
    WINNING_HEADER(NEW_LINE.message + "당첨 통계" + NEW_LINE.message + "---"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    TICKET_PREFIX("["),
    TICKET_SEPARATOR(", "),
    TICKET_SUFFIX("]"),
    SEPARATOR_REGEX(",");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
