package lotto.enums;

public enum ViewMessage {
    INPUT_PURCHASE_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),

    PRINT_PURCHASE_MESSAGE("\n%d개를 구매했습니다.\n"),
    PRINT_WINNING_STATISTICS_MESSAGE("\n당첨 통계\n"
            + "---\n"
            + "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - %d개\n"
            + "5개 일치 (1,500,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
            + "6개 일치 (2,000,000,000원) - %d개\n"),
    PRINT_INCOME_RATE_MESSAGE("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
