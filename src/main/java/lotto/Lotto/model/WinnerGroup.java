package lotto.Lotto.model;

public enum WinnerGroup {
    FIRST_PRIZE("1등", 6, 2000000000),
    SECOND_PRIZE("2등", 5, 30000000),
    THIRD_PRIZE("3등", 5, 1500000),
    FOURTH_PRIZE("4등", 4, 50000),
    FIFTH_PRIZE("5등", 3, 5000);
    private String rank;
    private int matchCount;
    private int prize;

    WinnerGroup(String rank, int matchCount, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public String getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
