package lotto.domain;

public enum ResultCode {

    FIRST(1, 2000000000), SECOND(2, 30000000), THIRD(3, 1500000), FOURTH(4, 50000), FIFTH(5, 5000);

    public int rank;
    public int prize;

    ResultCode(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }
}
