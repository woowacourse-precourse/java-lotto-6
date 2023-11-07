package lotto;

public enum RankPrize {
    FIRST(1, "2,000,000,000", 2000000000),
    SECOND(2, "30,000,000", 30000000),
    THIRD(3, "1,500,000", 1500000),
    FOURTH(4, "50,000", 50000),
    FIFTH(5, "5,000", 5000),
    NOPRIZE(0, "0", 0)
    ;

    private final int rank;
    private final String prizeStr;
    private final double prizeInt;


    RankPrize(int rank, String prizeStr, double prizeInt) {
        this.rank = rank;
        this.prizeStr = prizeStr;
        this.prizeInt = prizeInt;
    }

    int getRank() {
        return rank;
    }

    String getPrizeStr() {
        return prizeStr;
    }

    double getPrizeInt() {
        return prizeInt;
    }
}
