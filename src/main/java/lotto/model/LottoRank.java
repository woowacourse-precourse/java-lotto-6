package lotto.model;

public enum LottoRank {
    /**
     * 로또 당첨 순위: 1등
     */
    RANK_1ST(1, 2000000000),
    /**
     * 로또 당첨 순위: 2등
     */
    RANK_2ND(2, 30000000),
    /**
     * 로또 당첨 순위: 3등
     */
    RANK_3RD(3, 1500000),
    /**
     * 로또 당첨 순위: 4등
     */
    RANK_4TH(4, 50000),
    /**
     * 로또 당첨 순위: 5등
     */
    RANK_5TH(5, 5000);

    private final int rank;
    private final int price;

    LottoRank(int rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public int getPrice() {
        return price;
    }
}
