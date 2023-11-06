package lotto.models;

public enum LottoGrade {

    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    NONE(6, 0);

    final int rank;
    final int prizeMoney;

    LottoGrade(int rank, int prizeMoney) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public int getRank() {
        return rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
