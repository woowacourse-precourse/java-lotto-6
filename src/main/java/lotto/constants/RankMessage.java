package lotto.constants;

public enum RankMessage {
    FIFTH(3, 5000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final int winningPrize;
    private final String message;

    RankMessage(int matchCount, int winningPrize, String message) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
        this.message = message;
    }

    public long calculatePrizeMoney(int count) {
        return (long) winningPrize * count;
    }
    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }
}
