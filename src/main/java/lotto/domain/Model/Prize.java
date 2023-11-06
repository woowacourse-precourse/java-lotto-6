package lotto.domain.Model;

public enum Prize {
    FIFTH(5000, "3개 일치"),
    FOURTH(50000, "4개 일치"),
    THIRD(1500000, "5개 일치"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치"),
    WINNER(2000000000, "6개 일치");

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
        if (matchCount == 3) return FIFTH;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 5 && !matchBonus) return THIRD;
        if (matchCount == 5) return SECOND;
        if (matchCount == 6) return WINNER;
        return null;
    }
}