package lotto;

public enum Rank {
    FIRST(2_000_000_000, 6, "6개 일치 (2,000,000,000원) - "),
    SECOND(30_000_000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1_500_000,5, "5개 일치 (1,500,000원) - "),
    FOURTH(50_000, 4, "4개 일치 (50,000원) - "),
    FIFTH(5_000, 3, "3개 일치 (5,000원) - ");

    private final int prize;
    private final int wins;
    private final String message;

    Rank(int prize, int wins, String message) {
        this.prize = prize;
        this.wins = wins;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }
    public int getWins() { return wins; }
    public String getMessage() {return message; }
}
