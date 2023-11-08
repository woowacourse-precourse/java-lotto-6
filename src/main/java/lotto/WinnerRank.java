package lotto;

public enum WinnerRank {
    FIFTH_PLACE(5),
    FOURTH_PLACE(4),
    THIRD_PLACE(3),
    SECOND_PLACE(2),
    FIRST_PLACE(1);

    private final Integer rank;

    private WinnerRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }
}
