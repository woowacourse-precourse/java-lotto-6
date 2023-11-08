package lotto.view.message;

public enum ViewMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    NUMBER_OF_TICKETS_PURCHASED("%d개를 구매했습니다."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_HEADER("당첨 통계"),
    WINNING_STATISTICS_SEPARATOR("---"),
    WINNING_STATISTICS_FIFTH("3개 일치 (5,000원) - %d개\n"),
    WINNING_STATISTICS_FOURTH("4개 일치 (50,000원) - %d개\n"),
    WINNING_STATISTICS_THIRD("5개 일치 (1,500,000원) - %d개\n"),
    WINNING_STATISTICS_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    WINNING_STATISTICS_FIRST("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_PROFIT_PERCENTAGE("총 수익률은 %.1f%%입니다."),
    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int number) {
        return String.format(message, number);
    }

    public String getMessage(Float percent) {
        return String.format(message, percent);
    }
}
