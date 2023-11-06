package lotto.domain;

public enum Rank {
    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    FIRST(6, 200000000),
    SECOND(5, 30000000);


    private final int score;
    private final int prize;

    Rank(int score, int prize) {
        this.score = score;
        this.prize = prize;
    }

    public int getScore() {
        return score;
    }

    public int getPrize() {
        return prize;
    }
}
