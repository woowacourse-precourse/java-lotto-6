package lotto;

public enum Rank {
    LOSE_PLACE(6),
    FIFTH_PLACE(5),
    FOURTH_PLACE(4),
    THIRD_PLACE(3),
    SECOND_PLACE(2),
    FIRST_PLACE(1);

    private final Integer rank;

    private Rank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }
}
