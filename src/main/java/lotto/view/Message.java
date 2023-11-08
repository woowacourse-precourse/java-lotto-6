package lotto.view;

public enum Message {
    ASK_PAYMENT_MESSAGE("구입금액을 입력해 주세요."),
    ASK_MAIN_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("\n%d개를 구매했습니다.\n"),
    TICKET_MESSAGE("[%s]\n"),
    TICKET_NUMBER_DELIMITER(", "),
    MAIN_NUMBER_DELIMITER(","),
    NUMBER_PATTERN("\\d+"),
    MAIN_NUMBER_PATTERN("([\\d]+[,])*[\\d]+"),
    STATISTICS_MESSAGE("\n당첨 통계"),
    SEPARATOR_LINE_MESSAGE("---"),
    REVENUE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
