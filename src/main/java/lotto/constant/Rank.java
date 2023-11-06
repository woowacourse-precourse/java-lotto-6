package lotto.constant;

public enum Rank {

    SIXTH(0, 0, ""),
    FIFTH(5000, 3, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(50000, 4, "4개 일치 (50,000원) - %d개\n"),
    THIRD(1500000, 5, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(30000000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(2000000000, 6, "6개 일치 (2,000,000,000원) - %d개\n");

    private final int winnings;
    private final int count;
    private final String message;

    Rank(int winnings, int count, String message) {
        this.winnings = winnings;
        this.count = count;
        this.message = message;
    }

    public static Rank getRank(int count, boolean isBonus) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.THIRD && isBonus) {
                continue;
            }
            if (rank.count == count) {
                return rank;
            }
        }
        return Rank.SIXTH;
    }

    public int getWinnings() {
        return winnings;
    }

    public String getMessage() {
        return message;
    }
}
