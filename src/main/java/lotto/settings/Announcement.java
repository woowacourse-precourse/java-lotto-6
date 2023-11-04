package lotto.settings;

public enum Announcement {
    PURCHASE_AMOUNT_REQUEST("구입금액을 입력해 주세요."),
    PURCHASE_NUMBER("%d개를 구매했습니다."),
    LOTTO_WINNING_NUMBERS_REQUEST("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS_NUMBERS_REQUEST("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    LOTTO_WINNING_RESULTS("%d개 일치 (%s원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.2f입니다."),
    NEW_LINE("\n");

    private final String print;

    Announcement(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
