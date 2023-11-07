package lotto.constants;

public enum OutputMessage {

    PURCHASE_QUANTITY("%d개를 구매했습니다."),
    RANK_1("6개 일치 (2,000,000,000원) - %d개"),
    RANK_2("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RANK_3("5개 일치 (1,500,000원) - %d개"),
    RANK_4("4개 일치 (50,000원) - %d개"),
    RANK_5("3개 일치 (5,000원) - %d개"),
    PROFIT_RATE_INTRO("당첨 통계"),
    SEPARATOR("---"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    public String getMessage() {
        return message;
    }

    OutputMessage(String description) {
        this.message = description;
    }

    @Override
    public String toString() {
        return message;
    }

}
