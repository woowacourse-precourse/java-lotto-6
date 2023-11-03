package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5.5f, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private float matchCount;
    private int prize;
    Rank(float matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public boolean equals(float matchCount) {
        return this.matchCount == matchCount;
    }
}
