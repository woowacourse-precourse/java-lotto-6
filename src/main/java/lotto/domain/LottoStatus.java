package lotto.domain;

public enum LottoStatus {

    WAITING(-1, 0), OUT(0, 0), FIRST(1, 2000000000), SECOND(2, 30000000), THIRD(3, 1500000), FOURTH(4, 50000), FIFTH(5, 5000);

    public int rank;
    public int prize;

    LottoStatus(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }
}
