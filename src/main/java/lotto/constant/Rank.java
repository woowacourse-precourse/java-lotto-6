package lotto.constant;

public enum Rank {

    SIXTH(0, 0, ""),
    FIFTH(5000, 3, "3개 일치 (5,000원) - "),
    FOURTH(50000, 4, "4개 일치 (50,000원) - "),
    THIRD(1500000, 5, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, "6개 일치 (2,000,000,000원) - ");

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
