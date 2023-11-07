package lotto;

public enum Rank {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000,5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false);

    private final int prize;
    private final int wins;
    private final boolean bonus;

    Rank(int prize, int wins, boolean bonus) {
        this.prize = prize;
        this.wins = wins;
        this.bonus = bonus;
    }

    public int getPrize() {
        return prize;
    }
    public int getWins() { return wins; }
    public boolean getBonus() { return bonus; }
}
