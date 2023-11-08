package lotto.domain;

public enum LottoRank {
    RANK1(2000000000),
    RANK2(30000000),
    RANK3(1500000),
    RANK4(50000),
    RANK5(5000),
    RANK6(0);

    private final int prize;
    private int count;

    LottoRank(int prize) {
        this.prize = prize;
        this.count = 0;
    }

    public void increaseCount() {
        count++;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}
