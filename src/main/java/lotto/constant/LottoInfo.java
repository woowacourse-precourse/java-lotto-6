package lotto.constant;

public enum LottoInfo {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    NOPRIZE(6, 0);


    private final int rank;
    private final int prize;

    private LottoInfo(int rank, int prize){
        this.rank = rank;
        this.prize = prize;
    }

public int getRank() {
    return rank;
}

public int getPrize() {
    return prize;
}
}
