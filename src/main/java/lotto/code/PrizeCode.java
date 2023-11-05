package lotto.code;

public enum PrizeCode {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    ;

    PrizeCode(int prize, int prizeMoney) {
        this.prize = prize;
        this.prizeMoney = prizeMoney;
    }

    private int prize;
    private int prizeMoney;

    public int getPrize() {
        return prize;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
