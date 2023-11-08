// lotto.model.PrizeRank.java 파일
package lotto;

public enum WinningRanking {
    FIRST(5, 2000000000),
    SECOND(4, 30000000),
    THIRD(3, 1500000),
    FOURTH(2, 50000),
    FIFTH(1, 5000),
    LOSING(0, 0);

    private final int rank;
    private final int winningPrice;

    WinningRanking(int rank, int winningPrice) {
        this.rank = rank;
        this.winningPrice = winningPrice;
    }

    public int getRank() {
        return rank;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
