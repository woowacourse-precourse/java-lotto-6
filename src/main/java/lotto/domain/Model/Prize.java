package lotto.domain.Model;

public enum Prize {
    THREE(5000, "3개 일치"),
    FOUR(50000, "4개 일치"),
    FIVE(1500000, "5개 일치"),
    FIVE_PLUS(30000000, "5개 일치, 보너스 볼 일치"),
    SIX(2000000000, "6개 일치");

    private final int prize;
    private final String rank;

    Prize(int prize, String rank) {
        this.prize = prize;
        this.rank = rank;
    }

    public int getPrize() {
        return prize;
    }

    public String getRank() {
        return rank;
    }

    public static Prize prizeCount(int matchCount, boolean matchBonus) {
        if (matchCount == 3) return THREE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 5 && !matchBonus) return FIVE;
        if (matchCount == 5) return FIVE_PLUS;
        if (matchCount == 6) return SIX;
        return null;
    }
}