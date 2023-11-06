package lotto.constant;

public enum Rank {
    THREE_MATCH(3, false, 5000, "3개 일치 (5,000원) - "),
    FOUR_MATCH(4, false, 50000, "4개 일치 (50,000원) - "),
    FIVE_MATCH(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS_MATCH(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH(6, false, 2000000000, "6개 일치 (2,000,000,000원) - ");

    public final int matchCount;
    public final boolean isMatchBonus;
    public final int prize;
    public final String message;

    Rank(int matchCount, boolean isMatchBonus, int prize, String message) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }

    public static Rank getRankByMatchCount(int matchCount) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return null;
    }
}
