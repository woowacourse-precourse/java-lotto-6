package lotto.domain;

public enum LottoRank {
    RANK1(2000000000),
    RANK2(30000000),
    RANK3(1500000),
    RANK4(50000),
    RANK5(5000);

    private final int prize;

    LottoRank(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
