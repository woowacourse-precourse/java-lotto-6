package lotto.settings;

public enum Announcement {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_NUMBER("\n%d개를 구매했습니다."),
    REQUEST_LOTTO_WINNING_NUMBERS("\n\n당첨 번호를 입력해 주세요."),
    REQUEST_LOTTO_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    BUY_LOTTO("\n[ %s ]"),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    WINNING_RESULTS("%d개 일치 (%s원) - %d개.\n"),
    RATE_OF_RETURN("총 수익률은 %.2f입니다.\n"),
    NEW_LINE("\n");

    private final String print;

    Announcement(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
