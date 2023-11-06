package lotto.settings;

public enum Announcement {
    REQUEST_PURCHASE_AMOUNT("\n구입금액을 입력해 주세요."),
    PURCHASE_NUMBER("\n%d개를 구매했습니다."),
    REQUEST_LOTTO_WINNING_NUMBERS("\n\n당첨 번호를 입력해 주세요."),
    REQUEST_LOTTO_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    BUY_LOTTO("\n[%s]"),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    PER_LOTTO_TOTAL_COUNT("%d개\n");
    private final String print;

    Announcement(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
