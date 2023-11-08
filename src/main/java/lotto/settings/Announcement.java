package lotto.settings;

public enum Announcement {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_NUMBER("%d개를 구매했습니다."),
    REQUEST_LOTTO_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_LOTTO_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    BUY_LOTTO("[%s]"),
    WINNING_STATISTICS("당첨 통계\n---"),
    LOTTO_COUNT_PER_RANK("%d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String print;

    Announcement(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
