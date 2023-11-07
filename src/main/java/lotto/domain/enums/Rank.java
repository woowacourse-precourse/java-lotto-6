package lotto.domain.enums;

public enum Rank {
    FIRST("1등"), SECOND("2등"), THIRD("3등"), FOURTH("4등"), FIFTH("5등"), NOT("미당첨");

    private final String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "rank='" + rank + '\'' +
                '}';
    }
}
