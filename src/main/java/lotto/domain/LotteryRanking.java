package lotto.domain;

public enum LotteryRanking {
    LOTTO_5ST_PLACE(3,5000)
    ,LOTTO_4ST_PLACE(4, 50000)
    ,LOTTO_3ST_PLACE(5, 1500000)
    ,LOTTO_2ST_PLACE(51, 30000000)
    ,LOTTO_1ST_PLACE(6, 2000000000);

    private final Integer rankingKey;
    private final double price;

    LotteryRanking(Integer rankingKey, double price) {
        this.rankingKey = rankingKey;
        this.price = price;
    }

    public Integer getRankingKey() {
        return rankingKey;
    }

    public double getPrice() {
        return price;
    }
}
