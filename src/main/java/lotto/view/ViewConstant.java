package lotto.view;

public enum ViewConstant {

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
    FIFTH_PRIZE_MESSAGE("3개 일치 (5,000원) - %d개\n"),
    FOURTH_PRIZE_MESSAGE("4개 일치 (50,000원) - %d개\n"),
    THIRD_PRIZE_MESSAGE("5개 일치 (1,500,000원) - %d개\n"),
    SECOND_PRIZE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST_PRIZE_MESSAGE("6개 일치 (2,000,000,000원) - %d개\n"),
    REVENUE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String value;

    ViewConstant(String value) {
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
