package lotto.view.constants;

public enum ResponseMessage {
    PURCHASE_AMOUNT("%d개를 구매했습니다."),
    WINNING_STATS("당첨 통계\n"
            + "---\n"
            + "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - %d개\n"
            + "5개 일치 (1,500,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
            + "6개 일치 (2,000,000,000원) - %d개"),
    WINNING_PROFIT_RATE("총 수익률은 %f%%입니다.");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
