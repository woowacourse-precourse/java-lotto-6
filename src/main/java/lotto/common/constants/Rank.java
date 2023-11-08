package lotto.common.constants;

public enum Rank {
    FIRST_RANK("1st"),
    SECOND_RANK("2nd"),
    THIRD_RANK("3rd"),
    FOURTH_RANK("4th"),
    FIFTH_RANK("5th");

    private final String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
