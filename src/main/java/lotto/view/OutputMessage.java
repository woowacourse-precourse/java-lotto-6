package lotto.view;

public enum OutputMessage {
    PURCHASE("%d개를 구매했습니다."),
    PRIZE_GUIDE("당첨 통계\n" + "---"),
    THREE_MATCH("3개 일치 (5,000원) - %d개"),
    FOUR_MATCH("4개 일치 (50,000원) - %d개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개"),
    BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개"),
    GUIDE_RATE("총 수익률은 %s%%입니다.");

    public String getMessage(int quantity) {
        return String.format(message, quantity);
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String rate) {
        return String.format(message, rate);
    }

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }
}
