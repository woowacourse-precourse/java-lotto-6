package lotto.model;

public enum LottoRank {
    FIRST(1, 6, false, "2,000,000,000"),
    SECOND(2, 5, true, "30,000,000"),
    THIRD(3, 5, false, "1,500,000"),
    FOURTH(4, 4, false, "50,000"),
    FIFTH(5, 3, false, "5,000"),
    NONE(0, 0, false, "0");

    private final int rank;
    private final int matchCount;
    private final boolean isMatchBonus;
    private final String prize;

    LottoRank(int rank, int matchCount, boolean isMatchBonus, String prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }

    public String getPrize() {
        return prize;
    }
}
