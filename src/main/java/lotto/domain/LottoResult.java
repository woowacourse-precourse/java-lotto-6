package lotto.domain;

public class LottoResult {

    private final int rank;
    private final int prize;

    private LottoResult(int rank, int prize) {
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
