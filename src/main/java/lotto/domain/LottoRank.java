package lotto.domain;

public enum LottoRank {
    rank1(2000000000),
    rank2(30000000),
    rank3(1500000),
    rank4(50000),
    rank5(5000);

    private final int prize;

    LottoRank(int prize) {
        this.prize = prize;
    }
}
