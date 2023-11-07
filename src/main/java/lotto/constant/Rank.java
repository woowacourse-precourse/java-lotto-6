package lotto.constant;

public enum Rank {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    NO(0);

    private int rank;

    private Rank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
