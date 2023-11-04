package Model.Enum;

public enum Rank {
    FIFTH_RANK(3),
    FOURTH_RANK(4),
    THIRD_RANK(5),
    SECOND_RANK(5),
    FIRST_RANK(6);

    private final int rank;

    Rank(int rank) {
        this.rank = rank;
    }

    public int get() {
        return rank;
    }
}
