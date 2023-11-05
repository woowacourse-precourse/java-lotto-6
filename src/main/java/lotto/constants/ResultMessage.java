package lotto.constants;

public enum ResultMessage {
    THREE_MATCH(0, 3, 5000, "3개 일치 (5,000원) - %d개"),
    FOUR_MATCH(1, 4, 50000, "4개 일치 (50,000원) - %d개"),
    FIVE_MATCH(2, 5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    FIVE_MATCH_BONUS(3, 5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH(4, 6, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int index;
    private final int countMatch;
    private final int winningAmount;
    private final String message;

    ResultMessage(int index, int countMatch, int winningAmount, String message) {
        this.index = index;
        this.countMatch = countMatch;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public int getIndex() {
        return index;
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
