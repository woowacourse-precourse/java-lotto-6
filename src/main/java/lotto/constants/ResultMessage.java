package lotto.constants;

public enum ResultMessage {
    THREE_MATCH(3, 5000, "3개 일치 (5,000원) - %d개"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원) - %d개"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    FIVE_MATCH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int countMatch;
    private final int winningAmount;
    private final String message;

    ResultMessage(int countMatch, int winningAmount, String message) {
        this.countMatch = countMatch;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public int getCountMatch() {
        return countMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getMessage() {
        return message;
    }
}
