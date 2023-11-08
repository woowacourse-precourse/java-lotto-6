package domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000)
    ;

    final private int match;
    final private int prize;

    Rank(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }
}
